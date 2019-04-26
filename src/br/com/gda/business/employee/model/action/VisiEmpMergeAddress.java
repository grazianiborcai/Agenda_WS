package br.com.gda.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.address.info.AddressCopier;
import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.decisionTree.RootAddressSelect;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.info.EmpMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpMergeAddress extends ActionVisitorTemplateMerge<EmpInfo, AddressInfo> {
	
	public VisiEmpMergeAddress(Connection conn, String schemaName) {
		super(conn, schemaName, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<EmpInfo>> getMergerClassHook() {
		return EmpMerger.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		return AddressCopier.copyFromEmp(recordInfos);	
	}
}
