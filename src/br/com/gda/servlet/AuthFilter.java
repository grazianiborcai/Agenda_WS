package br.com.gda.servlet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.core.header.InBoundHeaders;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

import br.com.gda.dao.CustomerDAO;
import br.com.gda.helper.Customer;
import br.com.gda.helper.Owner;
import br.com.gda.model.OwnerModel;


public class AuthFilter implements ContainerRequestFilter {
	private static class HtmlRequestHeaderAttr {
		private String   	app		   ;
		private String   	htmlMethod ;
		private String   	uriPath    ;
		private String   	authBasic  ;
		private String   	username   ;
		private String 	 	password   ;
		private String		emailLogin ;
		private String      userCode   ;
		
		private HashMap<String, String> 		additionalParamMap	;
		private MultivaluedMap<String, String> 	incomeParamMap		;
		
		
		public HtmlRequestHeaderAttr(String app) {
			additionalParamMap 	= new HashMap<>();
			this.app 			= app			 ;
			this.userCode 		= "0"			 ;
		}		
		public MultivaluedMap<String, String> getIncomeParamMap() {
			return incomeParamMap;
		}
		public void setIncomeParamMap(MultivaluedMap<String, String> incomeParamMap) {
			this.incomeParamMap = incomeParamMap;
		}
		public String getUserCode() {
			return (this.userCode == null ? "0" : this.userCode);
		}
		public void setUserCode(String userCode) {
			this.userCode = userCode;
		}
		public String getEmailLogin() {
			return emailLogin;
		}
		public void setEmailLogin(String emailLogin) {
			this.emailLogin = emailLogin;
		}
		public void addParam(String paramName, String paramValue) {
			additionalParamMap.put(paramName, paramValue);
		}
		public String getParamValue(String paramName) {
			return additionalParamMap.get(paramName);
		}
		public String getApp() {
			return app;
		}
		public String getUsername() {
			return username;
		}
		public String getPassword() {
			return password;
		}	
		public void setUsernameAndPassword(String[] usernameAndPassword) {
			this.username = usernameAndPassword[0];
			this.password = usernameAndPassword[1];
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getHtmlMethod() {
			return htmlMethod;
		}
		public void setHtmlMethod(String htmlMethod) {
			this.htmlMethod = htmlMethod;
		}
		public String getUriPath() {
			return uriPath;
		}
		public void setUriPath(String uriPath) {
			this.uriPath = uriPath;
		}
		public String getAuthBasic() {
			return authBasic;
		}
		public void setAuthBasic(String authBasic) {
			this.authBasic = authBasic;
		}
		public InBoundHeaders getNewInputHeader() {
			InBoundHeaders resultHeader = new InBoundHeaders();
			
			for (Entry<String, List<String>> eachHeaderParam : this.incomeParamMap.entrySet()) {
				if (eachHeaderParam.getKey().equals(COD_CUSTOMER) || 
					eachHeaderParam.getKey().equals(PHONE)   	  || 
					eachHeaderParam.getKey().equals(EMAIL) 	   	  || 
					eachHeaderParam.getKey().equals(CPF)   	      || 
					eachHeaderParam.getKey().equals(PASSWORD)) {
					
					continue;
				}			
					
				if (eachHeaderParam.getValue().size() > 1)
					resultHeader.addObject(eachHeaderParam.getKey(), eachHeaderParam.getValue());
				else
					resultHeader.add(eachHeaderParam.getKey(), eachHeaderParam.getValue().get(0));
			}
			
			
			if (this.uriPath.equals("Customer/loginCustomer") || this.uriPath.equals("Owner/loginOwner")) {
				resultHeader.add(EMAIL   , this.username);
				resultHeader.add(PASSWORD, this.password);
			}
			
			
			if (this.app.equals(APP_CLIENT))
				addParam(COD_CUSTOMER, this.userCode);
			
			
			if (this.app.equals(APP_OWNER)) 
				addParam(COD_OWNER, this.userCode);
			

			Iterator<Map.Entry<String, String>> itr = additionalParamMap.entrySet().iterator();
			while (itr.hasNext()) {
				Map.Entry<String, String> paramPair = itr.next();
				resultHeader.add(paramPair.getKey(), paramPair.getValue());
			}
			
			
			return resultHeader;
		}
	}

	
	private static final HashSet<String> requestAuthNotRequired = new HashSet<>();
	HtmlRequestHeaderAttr headerAttr;
	
	static {
		requestAuthNotRequired.add("CodePassword/getCode" 	);
		requestAuthNotRequired.add("Customer/changePassword");
		requestAuthNotRequired.add("Customer/insertCustomer");
		requestAuthNotRequired.add("Owner/changePassword" 	);
		requestAuthNotRequired.add("Owner/insertOwner"		);
		requestAuthNotRequired.add("Time/getTime" 			);
		requestAuthNotRequired.add("Token/getToken" 		);
	}
	
	
	//private static final String CLIENT_LOGIN = "client";

	// Header parameters key
	private static final String AUTHORIZATION = "authorization";
	//private static final String TOKENREQ = "token";
	private static final String APP = "app";
	//private static final String ZONE_ID = "zoneId";

	// Parameter that is passed in the HTTP header parameter
	private static final String COD_OWNER = "codOwner";
	private static final String PHONE = "phone";
	private static final String COD_CUSTOMER = "codCustomer";
	private static final String PASSWORD = "password";
	private static final String CPF = "cpf";
	private static final String EMAIL = "email";
	private static final String EMAIL_LOGIN = "emailLogin";
	private static final String APP_CLIENT = "client";
	private static final String APP_OWNER = "owner";

	/**
	 * Apply the filter : check input request, validate or not with user auth
	 * 
	 * @param containerRequest
	 *            The request from Tomcat server
	 */
	@Override
	public ContainerRequest filter(ContainerRequest containerRequest) throws WebApplicationException {
		setHeaderAttribute(containerRequest);
		
			
		if (isHtmlMethodBlackListed()) 
			throw new WebApplicationException(Status.UNAUTHORIZED);
		
		
		getUserInfo();
		
		
		if (isHtmlRequestFreeOfAuthentication()) {
			containerRequest.setHeaders(this.headerAttr.getNewInputHeader());
			return containerRequest;
		}
		
		
		if (isMandatoryFieldEmpty(headerAttr))
			throw new WebApplicationException(Status.UNAUTHORIZED);		
				
		
		if (isUserInvalid())
			throw new WebApplicationException(Status.UNAUTHORIZED);		
				
		
		containerRequest.setHeaders(this.headerAttr.getNewInputHeader());
		return containerRequest;
	}
	
	
	
	private boolean isHtmlMethodBlackListed() {
		String methodName = this.headerAttr.getHtmlMethod();
		
		if (methodName.equals("POST") || methodName.equals("GET")) {
			return false;
		}
		
		return true;
	}
	
	
	
	
	private boolean isHtmlRequestFreeOfAuthentication() {
		String uriPath = this.headerAttr.getUriPath();
		return AuthFilter.requestAuthNotRequired.contains(uriPath);
	}
	
	
	
	private String[] getUsernameAndPassword(String authBasic) throws WebApplicationException {
		String[] tempResult = BasicAuth.decode(authBasic);
		
		if (tempResult == null || tempResult.length != 2) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}		

		return tempResult;	
	}
	
	
	

	
	
	
	private Customer getCustomerFromUsernameAndPassword(String username, String password) {		
		try {
			List<String> emailList = new ArrayList<String>();
			emailList.add(username);
			
			List<String> passwordList = new ArrayList<String>();
			passwordList.add(password);
			
			ArrayList<Customer> customerList = new CustomerDAO().selectCustomer(null, null, passwordList, null, null, null,
					null, emailList, null, null, null, null, null, null);
		
			
			if (customerList == null)
				return new Customer();
			
			if (customerList.isEmpty())
				return new Customer();
		
			return customerList.get(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return new Customer();
		}
	}
	
	
	
	private Customer getCustomerFromUsername(String username) {		
		try {
			List<String> emailList = new ArrayList<String>();
			emailList.add(username);
			
			ArrayList<Customer> customerList = new CustomerDAO().selectCustomer(null, null, null, null, null, null,
					null, emailList, null, null, null, null, null, null);
		
			
			if (customerList == null)
				return new Customer();
			
			if (customerList.isEmpty())
				return new Customer();
		
			return customerList.get(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return new Customer();
		}
	}
	
	
	
	private Owner getOwnerFromUsername(String username) {		
		try {			
			ArrayList<Owner> ownerList = new OwnerModel().selectOwner(username, null, null, null, false, false, false, false,
					false, false, false, false, false, false, "Z");
			
			if (ownerList == null)
				return new Owner();
			
			if (ownerList.isEmpty())
				return new Owner();
			
			return ownerList.get(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return new Owner();
		}
	}
	
	
	
	private Owner getOwnerFromUsernameAndPassword(String username, String password) {
		try {			
			ArrayList<Owner> ownerList = new OwnerModel().selectOwner(username, null, password, null, false, false, false, false,
					false, false, false, false, false, false, "Z");
			
			if (ownerList == null)
				return new Owner();
			
			if (ownerList.isEmpty())
				return new Owner();
			
			return ownerList.get(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return new Owner();
		}
	}
	
	
	
	private void getUserInfo() {	
		if (this.headerAttr.getApp().equals(APP_CLIENT)) {
			Customer customer;
			
			if (this.headerAttr.getUriPath().equals("CodePassword/getCode") || this.headerAttr.getUriPath().equals("Customer/changePassword")) {
				customer = getCustomerFromUsername(this.headerAttr.getUsername());
			} else {			
				customer = getCustomerFromUsernameAndPassword(this.headerAttr.getUsername(), this.headerAttr.getPassword());
			}
			
			setHeaderAttributteFromCustomer(customer);
		}
		
		
		if (headerAttr.getApp().equals(APP_OWNER)) {
			Owner owner;
			
			if (this.headerAttr.getUriPath().equals("Owner/getCode") || this.headerAttr.getUriPath().equals("Owner/changePassword")) {
				owner = getOwnerFromUsername(this.headerAttr.getUsername());
			} else {			
				owner = getOwnerFromUsernameAndPassword(headerAttr.getUsername(), headerAttr.getPassword());
			}
			
			setHeaderAttributteFromOwner(owner);
		}
	}
	
	
	
	private void setHeaderAttributteFromCustomer(Customer customer) {		
		headerAttr.addParam(COD_CUSTOMER, customer.getCodCustomer() == null ? null : customer.getCodCustomer().toString().toString());
		headerAttr.addParam("codPayment", customer.getCodPayment());
		headerAttr.addParam(PHONE, customer.getPhone());
		headerAttr.addParam(EMAIL, customer.getEmail());
		headerAttr.addParam(PASSWORD, customer.getPassword());
		headerAttr.addParam("name", customer.getName());
		headerAttr.setUserCode(customer.getCodCustomer() == null ? null : customer.getCodCustomer().toString());
	}
	
	
	
	private void setHeaderAttributteFromOwner(Owner owner) {
		headerAttr.addParam(COD_OWNER, (owner.getCodOwner() == null ? null : owner.getCodOwner().toString()));
		headerAttr.setUserCode(owner.getCodOwner() == null ? null : owner.getCodOwner().toString());
	}
	
	
	
	private void setHeaderAttribute(ContainerRequest containerRequest) {
		initializeHeaderAttribute(containerRequest);
		setHeaderGeneralAttribute(containerRequest);
	}
	
	
	
	private void initializeHeaderAttribute(ContainerRequest containerRequest) {
		this.headerAttr = new HtmlRequestHeaderAttr(containerRequest.getHeaderValue(APP));
	}
	
	
	
	private void setHeaderGeneralAttribute(ContainerRequest containerRequest) {
		this.headerAttr.setHtmlMethod(containerRequest.getMethod());
		this.headerAttr.setUriPath(containerRequest.getPath(true));
		this.headerAttr.setAuthBasic(containerRequest.getHeaderValue(AUTHORIZATION));
		this.headerAttr.setEmailLogin(containerRequest.getHeaderValue(EMAIL_LOGIN));
		this.headerAttr.setIncomeParamMap(containerRequest.getRequestHeaders());
		
		if (this.headerAttr.getAuthBasic() == null) {
			this.headerAttr.setUsername(containerRequest.getHeaderValue(EMAIL_LOGIN));
		} else {
			this.headerAttr.setUsernameAndPassword(getUsernameAndPassword(headerAttr.getAuthBasic()));
		}
	}
	
	
	
	private boolean isMandatoryFieldEmpty(HtmlRequestHeaderAttr headerAttr) {
		if (headerAttr.getAuthBasic() == null)
			return true;
		
		
		return false;
	}
	
	
	
	boolean isUserInvalid() {
		if (Long.valueOf(this.headerAttr.getUserCode()) <= 0 )
			return true;
		
		
		return false;
	}
}
