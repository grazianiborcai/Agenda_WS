package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.business.store.model.decisionTree.StoreEmpActionSelect;
import br.com.gda.business.store.model.decisionTree.StoreEmpRootDelete;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionNestedTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpActionDeleteStoreEmp extends DeciActionNestedTemplate<EmpInfo, StoreEmpInfo>{

	public EmpActionDeleteStoreEmp(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<StoreEmpInfo> translateRecordInfosHook(List<EmpInfo> recordInfos) {
		List<StoreEmpInfo> transInfos = new ArrayList<>();
		
		for (EmpInfo eachRecord : recordInfos) {
			transInfos.add(eachRecord.toStoreEmpInfo());
		}
		
		return transInfos;
	}
	
	
	
	@Override protected Class<? extends DeciAction<StoreEmpInfo>> getClassOfStarterHook() {
		return StoreEmpActionSelect.class;
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoreEmpInfo>> getClassOfTreeHook() {
		return StoreEmpRootDelete.class;
	}
	
	
	
	@Override protected List<EmpInfo> getResultsetHook(DeciResult<StoreEmpInfo> decisionResult) {
		EmpInfo emptyInfo = new EmpInfo();
		
		List<EmpInfo> resultList = new ArrayList<>();
		resultList.add(emptyInfo);
		
		return resultList;
	}

}
