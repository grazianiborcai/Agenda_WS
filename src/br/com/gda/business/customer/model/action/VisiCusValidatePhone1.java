package br.com.gda.business.customer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneValidate;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiCusValidatePhone1 extends ActionVisitorTemplateAction<CusInfo, PhoneInfo> {
	public VisiCusValidatePhone1(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class, PhoneInfo.class);
	}
	
	
	
	//TODO: Seria melhor mover essa transformacao para outra classe?
	@Override protected List<PhoneInfo> toActionClassHook(List<CusInfo> recordInfos) {
		List<PhoneInfo> results = new ArrayList<>();
		
		for (CusInfo eachRecord : recordInfos) {
			PhoneInfo actionInfo = translateToActionInfo(eachRecord);
			results.add(actionInfo);
		}		
		
		return results;
	}
	
	
	
	private PhoneInfo translateToActionInfo(CusInfo recordInfo) {
		PhoneInfo actionInfo = new PhoneInfo();
		actionInfo.codCountryPhone = recordInfo.codCountryPhone1;
		actionInfo.phoneNumber = recordInfo.phoneNumber1;
		return actionInfo;
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> getActionHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneValidate(option).toAction();
	}
}
