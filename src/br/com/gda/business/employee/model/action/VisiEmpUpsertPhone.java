package br.com.gda.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.phone.info.PhoneCopier;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneUpsertdel;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiEmpUpsertPhone extends ActionVisitorTemplateAction<EmpInfo, PhoneInfo> {
	public VisiEmpUpsertPhone(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		return PhoneCopier.copyFromEmp(recordInfos);
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> getActionHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneUpsertdel(option).toAction();
	}
}
