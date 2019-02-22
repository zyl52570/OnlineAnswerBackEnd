
package com.onlineanswer.hc.utils;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 */
@Configuration
public class MybatisPlusConfigurer {
	/**
	 * 分页插件
	 *
	 * @return PaginationInterceptor
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

}
