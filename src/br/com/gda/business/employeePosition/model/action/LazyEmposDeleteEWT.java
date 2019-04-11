package br.com.gda.business.employeePosition.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.gda.business.employeeWorkTime.model.decisionTree.RootEmpwotmDelete;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStowotmSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyEmposDeleteEWT extends ActionLazyTemplate<EmposInfo, EmpwotmInfo> {
	private Connection conn;
	private String schemaName;
	
	
	public LazyEmposDeleteEWT(Connection conn, String schemaName) {
		super(conn, schemaName);
		this.conn = conn;
		this.schemaName = schemaName;
	}
	
	
	
	@Override protected List<EmpwotmInfo> translateRecordInfosHook(List<EmposInfo> recordInfos) {
		List<StowotmInfo> storeWTs = getStoreWTime(recordInfos);
		return merge(recordInfos, storeWTs);
	}
	
	
	
	private List<StowotmInfo> getStoreWTime(List<EmposInfo> recordInfos) {
		DeciTree<StowotmInfo> treeSelect = new RootStowotmSelect(makeStoreWTOption(recordInfos));
		treeSelect.makeDecision();
		return treeSelect.getDecisionResult().getResultset();
	}
	
	
	
	private DeciTreeOption<StowotmInfo> makeStoreWTOption(List<EmposInfo> recordInfos) {
		DeciTreeOption<StowotmInfo> option = new DeciTreeOption<>();
		option.conn = this.conn;
		option.schemaName = this.schemaName;
		option.recordInfos = StowotmInfo.copyFrom(recordInfos);		
		return option;
	}
	
	
	
	private List<EmpwotmInfo> merge(List<EmposInfo> storeEmps, List<StowotmInfo> storeWTs) {
		return new EmpwotmMerger().merge(storeEmps, storeWTs);
	}
	
	
	
	@Override protected  ActionStd<EmpwotmInfo> getInstanceOfActionHook(DeciTreeOption<EmpwotmInfo> option) {
		return new RootEmpwotmDelete(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmposInfo> translateResultHook(DeciResult<EmpwotmInfo> result) {
		DeciResultHelper<EmposInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		
		List<EmposInfo> emptyResultset = new ArrayList<>();
		emptyResultset.add(new EmposInfo());
		
		resultHelper.resultset = emptyResultset;
		
		return resultHelper;
	}
}
