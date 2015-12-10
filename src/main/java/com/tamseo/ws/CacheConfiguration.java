package com.tamseo.ws;

/**
 * @author tam.nguyenvan
 */

import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

  /**
   * Create a CacheManager implementation class to be used by Spring where <code>@Cacheable</code>
   * annotations are applied.
   * 
   * @return A CacheManager instance.
   */
  @Bean
  public CacheManager cacheManager() {
    GuavaCacheManager cacheManager = new GuavaCacheManager("restonet");
    return cacheManager;
  }

}
