package br.com.gda.business.storeEmployee.model.decisionTree;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStoreWTimeSelect;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciReqTemplate;
import br.com.gda.model.decisionTree.DeciResuTranslator;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ReqStoreEmpSelectSWT extends DeciReqTemplate {
	
	public ReqStoreEmpSelectSWT(DeciTreeOption<StoreEmpInfo> option) {
		super(getAction(option));
	}
	
	
	
	static private DeciAction<StoreWTimeInfo> getAction(DeciTreeOption<StoreEmpInfo> option) {
		return new RootStoreWTimeSelect(translateOption(option)).toAction();
	}
	
	
	
	static private DeciTreeOption<StoreWTimeInfo> translateOption(DeciTreeOption<StoreEmpInfo> option) {
		DeciTreeOption<StoreWTimeInfo> newOption = new DeciTreeOption<>();
		newOption.conn = option.conn;
		newOption.schemaName = option.schemaName;
		newOption.recordInfos = StoreWTimeInfo.copyFrom(option.recordInfos);
		return newOption;
	}
	
	
	
	@Override protected DeciResuTranslator getTranslatorHook() {
		return null;
	}
}
