
/*
 * The MIT License
 *
 * Copyright 2017 Intuit Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.onesite.karate.demo.controller;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onesite.karate.demo.config.ServerStartedInitializingBean;
import com.onesite.karate.demo.domain.User;


@RestController
@RequestMapping("/users")
public class UsersController {
	
	 private final AtomicInteger counter = new AtomicInteger();
	    private final Map<Integer, User> users = new ConcurrentHashMap<>();
	    
	    private static final Logger logger = LoggerFactory.getLogger(ServerStartedInitializingBean.class);
	    
	    @PostMapping
	    public User create(@RequestBody User user) {
	    	
	    	logger.info("  in UsersController class of ceate ....");
	        int id = counter.incrementAndGet();
	        user.setId(id);
	        users.put(id, user);
	        return user;
	    }
	    
	    @GetMapping
	    public Collection<User> list() {
	        return users.values();
	    }
	    
	    @GetMapping("/{id:.+}")
	    public User get(@PathVariable int id) {
	        return users.get(id);
	    }
	    
	    @GetMapping("/{id:.+}/users")
	    public Collection<User> getUsers(@PathVariable int id) {
	        return users.get(id).getUsers();
	    } 
	    
	    @PutMapping("/{id:.+}")
	    public User put(@PathVariable int id, @RequestBody User user) {
	        users.put(id, user);
	        return user;        
	    }    
	    
	    @DeleteMapping("/{id:.+}")
	    public void delete(@PathVariable int id) {        
	        User user = users.remove(id);
	        if (user == null) {
	            throw new RuntimeException("user not found, id: " + id);
	        }
	    }

	    @DeleteMapping
	    public void deleteWithBody(@RequestBody User user) {
	        int id = user.getId();
	        delete(id);
	    }    
	    

}
