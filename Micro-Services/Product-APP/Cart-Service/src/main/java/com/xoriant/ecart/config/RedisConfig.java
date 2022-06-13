package com.xoriant.ecart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.xoriant.ecart.model.ItemLine;

@Configuration
public class RedisConfig {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {

		return new JedisConnectionFactory(); // localhost: 6379
	}

	@Bean
	public RedisTemplate<String, ItemLine> redisTemplate() {
		
		final RedisTemplate<String, ItemLine> template = new RedisTemplate<String, ItemLine>();
		template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

}
