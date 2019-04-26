package br.com.gda.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.info.EmpMerger;
import br.com.gda.business.phone.info.PhoneCopier;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpMergePhone extends ActionVisitorTemplateMerge<EmpInfo, PhoneInfo> {
	
	public VisiEmpMergePhone(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return RootPhoneSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<EmpInfo>> getMergerClassHook() {
		return EmpMerger.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		return PhoneCopier.copyFromEmp(recordInfos);	
	}
}
