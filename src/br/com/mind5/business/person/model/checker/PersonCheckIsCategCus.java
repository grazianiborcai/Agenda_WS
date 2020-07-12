package br.com.mind5.business.person.model.checker;

import java.sql.Connection;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.entityCategory.info.Entiteg;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class PersonCheckIsCategCus extends ModelCheckerTemplateSimpleV2<PersonInfo> {

	public PersonCheckIsCategCus(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PersonInfo recordInfo, Connection conn, String schemaName) {	
		if ( isCustomer(recordInfo.codEntityCateg) == super.SUCCESS )			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	private boolean isCustomer(String codEntityCateg) {
		if (codEntityCateg == null)
			return super.FAILED;
		
		String codCategCustomer = Entiteg.CUSTOMER.getCodEntityCateg();
		return codEntityCateg.equals(codCategCustomer);
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_MANDATORY_FIELD_EMPTY;
	}
}
