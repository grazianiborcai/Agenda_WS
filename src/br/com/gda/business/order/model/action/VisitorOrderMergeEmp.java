package br.com.gda.business.order.model.action;

import java.sql.Connection;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.decisionTree.RootEmpSelect;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisitorOrderMergeEmp extends ActionVisitorTemplateMerge<OrderInfo, EmpInfo> {
	
	public VisitorOrderMergeEmp(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpInfo>> getTreeClassHook() {
		return RootEmpSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<OrderInfo>> getMergerClassHook() {
		return OrderMerger.class;
	}
}
