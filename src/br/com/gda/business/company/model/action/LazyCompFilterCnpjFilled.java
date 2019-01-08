package br.com.gda.business.company.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyCompFilterCnpjFilled extends ActionLazyTemplate<CompInfo, CompInfo> {
	
	public LazyCompFilterCnpjFilled(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CompInfo> translateRecordInfosHook(List<CompInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CompInfo> getInstanceOfActionHook(DeciTreeOption<CompInfo> option) {
		return new StdCompFilterCnpjFilled(option);
	}
	
	
	
	@Override protected DeciResult<CompInfo> translateResultHook(DeciResult<CompInfo> result) {		
		return result;
	}
}
