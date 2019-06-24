package br.com.gda.payment.customerMoip.model.checker;

import java.sql.Connection;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.customerMoip.info.CusmoipInfo;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

public final class CusmoipCheckWrite extends ModelCheckerTemplateSimple<CusmoipInfo> {

	public CusmoipCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (checkSetupData(recordInfo.setuparData) == super.FAILED)
			return super.FAILED;
		
		if (checkUserap(recordInfo.userapData) == super.FAILED)
			return super.FAILED;
			
		if (checkPhonap(recordInfo.phonapData) == super.FAILED)
			return super.FAILED;
		
		if (checkAddresnap(recordInfo.addresnapData) == super.FAILED)
			return super.FAILED;
		
		if (recordInfo.codUserExt == null)
			return super.FAILED;

		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkSetupData(SetuparInfo setuparData) {
		if (setuparData == null)
			return super.FAILED;
		
		
		if (setuparData.key   == null ||
		    setuparData.token == null	 )	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	private boolean checkUserap(UserapInfo userapData) {
		if (userapData == null)
			return super.FAILED;
		
		
		if (userapData.personData == null)
			return super.FAILED;
		
		
		if (userapData.personData.name   	== null ||
			userapData.personData.email 	== null	||
			userapData.personData.birthDate	== null	||
			userapData.personData.cpf		== null)	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	private boolean checkPhonap(PhonapInfo phonapData) {
		if (phonapData == null)
			return super.FAILED;
		
		
		if (phonapData.codCountry	== null ||
			phonapData.fullNumber	== null)	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	private boolean checkAddresnap(AddresnapInfo addresnapData) {
		if (addresnapData == null)
			return super.FAILED;
		
		
		if (addresnapData.city			== null ||
			addresnapData.district 		== null	||
			addresnapData.street		== null ||
			addresnapData.streetNumber 	== null	||
			addresnapData.txtState 		== null	||
		  //addresnapData.txtCountry 	== null	||
			addresnapData.postalCode 	== null)	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
