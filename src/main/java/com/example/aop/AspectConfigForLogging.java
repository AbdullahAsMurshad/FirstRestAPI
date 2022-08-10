package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectConfigForLogging {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	/*
	 * Before  Advice  start  its execution before the actual requested  method being call
	 * here we can define number of objects in args(<---->)
	 *The same number of  object  we have to write in method  header  
	 *otherwise  spring app will not start itself.
	 */

	@Before(value = "execution(* com.example.controller.StudentController.*(..))  and args(object)")
	public void beforeAdviceStudentController(JoinPoint joinPoint, Object  object) {
		logger.info("Inside StudentController class using before Advice");
		logger.info("Request: "+object);

	}
	
	/*
	 * The After Advice  will be execute just before return point  of  the actual requested  method
	 * in this we don't know  what method  is going  to return  as it is  being  called just before the return point
	 * after this method execution return point statement will be executed immediately.
	 */
	
//	@After(value = "execution(* com.example.controller.StudentController.*(..)) and args(object1,object2)")
//	public void afterAdviceStudentController(JoinPoint joinPoint ,Object object1, Object object2) {
//		logger.info("Inside StudentController class using after Advice");
//		logger.info("Request: "+object1+" and "+object2);
//
//	}
//	
	
	/*
	 * AfterReturning executes just after return statement executes.
	 * In this we have both the method parameters and returned  value as well, as this  is being called just after
	 * the return statement executes.
	 */
	
//	@AfterReturning(value = "execution(* com.example.controller.StudentController.*(..)) and args(object)", returning= "returningObject")
//	public void afterReturingAdviceStudentController(JoinPoint joinPoint, Object object, Object returningObject) {
//		logger.info("Inside StudentController class using afterReturning Advice");
//		logger.info("Request: "+object);
//		logger.info("Response = "+returningObject);
//
//	}
	
	/*
	 * Around statement got executed twice once before executed  the  actual requested  method  and once  just before  return
	 * statement executes.  In this  we have 
	 * method  parameters
	 * returned value
	 * as well as we  have to call proceed method  using ProceedingJoinPoint  otherwise actual method  will not  execute
	 * 
	 */
	
	
	
//	@Around(value = "execution(* com.example.controller.StudentController.*(..)) and args(object)")
//	public void aroundAdviceStudentController(ProceedingJoinPoint proceedingJoinPoint, Object  object) {
//		Object returingObject=null;
//		logger.info("Inside StudentController class using around Advice");
//		logger.info("Request: "+object);
//		
//		try {
//			returingObject= proceedingJoinPoint.proceed();
//						
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		logger.info("Response = "+returingObject);
//	}
	
	
	
}
