import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import axios from 'axios';


const App = () => {

  const [products, setProducts] = useState([]);
  useEffect(() => {

    axios.get('http://localhost:8081/api/products')
      .then(products => {
        console.log(products.data);
        setProducts(products.data);
      })


  }, [])

  function renderProducts() {
    return products.map((product, idx) => {
      return (
        <tr key={idx}>
          <td>{product.productId}</td>
          <td>{product.productName}</td>
          <td>{product.price}</td>
          <td>{product.category.categoryTitle}</td>
          <td>{product.description}</td>
          <td>{product.quantity}</td>
        </tr>
      )
    })
  }

  return (
    <div className="container">

      <div className="alert alert-info text-center text-primary">
        <h1>ABC e-Cart Application</h1>
      </div>

      <hr />

      <div>

        <table className="table table-dark">

          <tbody>
            {renderProducts()}
          </tbody>


        </table>

      </div>





    </div>
  );
};

export default App;