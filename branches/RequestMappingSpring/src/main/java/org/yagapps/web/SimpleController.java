package org.yagapps.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/simple")
public class SimpleController {
	
	@RequestMapping(value="*")
	@ResponseBody
	public String fallBackForAllRequests(){
		return "Fall Back For All Requests";
	}
	
	@RequestMapping(value="get1",method=RequestMethod.GET)
	@ResponseBody
	public String getMethodReq(){
		return "For get method Requests";
	}

	@RequestMapping(value="post1" ,method=RequestMethod.POST)
	@ResponseBody
	public String postMethodReq()
	{
		return "Post http method request handler";
	}
	
	@RequestMapping(value="header1" ,headers="key=val")
	@ResponseBody
	public String reqMapWithHeaders()
	{
		return "this is req mapping with headers key=val";
	}
	
	@RequestMapping(value="headers" ,headers={"key1=val1","key2=val2"})
	@ResponseBody
	public String reqmapWithMultipleHeaders()
	{
		return "This is req mapping with multiple headers";
	}
	
	@RequestMapping(value="produce" , produces="application/json")
	@ResponseBody
	public Student reqmappingWithProducesJson()
	{
		return new Student();
	}
	
	
	@RequestMapping(value="pathvar/{id}/first/{name}")
	@ResponseBody
	public String reqpMappingPathVar(@PathVariable long id,@PathVariable String name)
	{
		return "this is req mapping with path variable "+id+" with "+ name;
	}
	
	@RequestMapping(value="reqparam")
	@ResponseBody
	public String reqParamMapping(@RequestParam("id") long id){
		return "this is req param mapping with param "+ id;
	}
	
	
	@RequestMapping(value="reqparam" ,params="id")
	@ResponseBody
	public String reqParamMapping1(@RequestParam("id") long id){
		return "this is req param mapping with param1 "+ id;
	}
	
	@RequestMapping(value={"map1","map2"})
	@ResponseBody
	public String multipleMapping(HttpServletRequest req){
		return "multiple mapping " + req.getRequestURI();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
