/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package edu.eci.cvds.beans;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name="loginInicialBean")
@ViewScoped


/**
 * Simple Quickstart application showing how to use Shiro's API.
 *
 * @since 0.9 RC2
 */
public class ShiroBean implements Serializable{

    private static final transient Logger log = LoggerFactory.getLogger(ShiroBean.class);
	
	private String usuario;
	private String password;
	
	public Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
	public void doLogin(){
		Subject usuarioActual = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(getUsuario(), getPassword());
		try{
			usuarioActual.login(token);
			usuarioActual.getSession().setAttribute("usuario",usuario);
			if(usuario.toLowerCase().equals("admin")){
				FacesContext.getCurrentInstance().getExternalContext().redirect("Admin.xhtml");
			}
			else{
				System.out.println("NO ESTA ENTRANDO EN ADMIN");
			}
			
		}
		catch(UnknownAccountException e){
			facesError("Unknown account");
            log.error(e.getMessage(), e);
		}
		catch(IncorrectCredentialsException e){
			facesError("Wrong paswword");
            log.error(e.getMessage(), e);
		}
		catch(LockedAccountException e){
			facesError("Locked account");
            log.error(e.getMessage(), e);
		}
		catch(AuthenticationException e){
			facesError("Bad Authentication");
            log.error(e.getMessage(), e);
		}
		catch(IOException e){
			facesError("Error");
            log.error(e.getMessage(), e);			
		}
	}
		
		private void facesError(String message) {
			FacesContext.getCurrentInstance().addMessage("ShiroEEE", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "errorEEE"));
		}
		
		public String getUsuario(){
			return usuario;
		}
		
		public String getPassword(){
			return password;
		}
		
		public void setUsuario(String usuario){
			this.usuario = usuario;
		}
		
		public void setPassword(String pssword){
			this.password=pssword;
		}
	

	}
	