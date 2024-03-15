//package com.aclpoc.interceptor;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.aclpoc.jwt.JwtService;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class CustomRequestInterceptor implements HandlerInterceptor {
//	
//	@Autowired
//	private JwtService jwtService;
//	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		
//		try {
//			String authorization = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
//			if (authorization.startsWith("Bearer")) {
//				String jwttoken = authorization.substring("Bearer".length()).trim();
////				jwttoken
////				byte[] decodedBytes = Base64.getDecoder().decode(encoded);
////			    String decoded = new String(decodedBytes, StandardCharsets.UTF_8);
////			    // credentials = username:password
////			    final String[] values = decoded.split(":", 2);
//			}
//			else if (authorization.startsWith("Basic")) {
//				String encoded = authorization.substring("Basic".length()).trim();
//				byte[] decodedBytes = Base64.getDecoder().decode(encoded);
//			    String decoded = new String(decodedBytes, StandardCharsets.UTF_8);
//			    // credentials = username:password
//			    final String[] values = decoded.split(":", 2);
//			    String username = values[0];
//			    String pass = values[1];
//			}
//			
//			//			request.getHeaderNames().asIterator().forEachRemaining(e -> System.out.println("## Header: "+e));
////			request.getHeader("authorization")
////			System.out.println("## HEader names",request.getHeaderNames().);
//			System.out.println("1 - preHandle() : Before sending request to the Controller"); 
//            System.out.println("Method Type: " + request.getMethod()); 
//            System.out.println("Request URL: " + request.getRequestURI()); 
//		}
//		catch (Exception e) {
//			System.out.println("ERRRROR: "+e);
//		}
//		
//		return HandlerInterceptor.super.preHandle(request, response, handler);
//	}
//	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		try { 
//            System.out.println("2 - postHandle() : After the Controller serves the request (before returning back response to the client)"); 
//            System.out.println("Method Type: " + request.getMethod()); 
//            System.out.println("Request URL: " + request.getRequestURI()); 
////            handler
//		}
//		
//        catch (Exception e) { 
//            e.printStackTrace(); 
//        } 
//		
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//	}
//}
