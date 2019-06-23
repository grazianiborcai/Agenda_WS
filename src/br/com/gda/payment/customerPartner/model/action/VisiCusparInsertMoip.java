package br.com.gda.payment.customerPartner.model.action;

import java.sql.Connection;
import java.util.List;
import br.com.gda.model.action.ActionVisitorAction;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.moip.Authentication;
import br.com.moip.BasicAuth;
import br.com.moip.Moip;


final class VisiCusparInsertMoip implements ActionVisitorAction<CusparInfo> {
	
	public VisiCusparInsertMoip(Connection conn, String schemaName) {
		
	}

	
	@Override public DeciResult<CusparInfo> executeTransformation(List<CusparInfo> recordInfos) {
		
		for (CusparInfo eachRecord : recordInfos) {
			Moip setup = setSetup(eachRecord);
			
		}
		
		
		

		
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	private Moip setSetup(CusparInfo recordInfo) {
		Authentication auth = getAuthentication(recordInfo);
		String env = getEnvironment(recordInfo);
		 return new Moip(auth, env);
	}
	
	
	
	private Authentication getAuthentication(CusparInfo recordInfo) {
		return new BasicAuth(recordInfo.setuparData.token, recordInfo.setuparData.key);
	}
	
	
	
	private String getEnvironment(CusparInfo recordInfo) {
		return Moip.SANDBOX_ENDPOINT;
	}

}
