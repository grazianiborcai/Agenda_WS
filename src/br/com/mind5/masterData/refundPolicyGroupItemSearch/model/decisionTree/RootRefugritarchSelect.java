package br.com.mind5.masterData.refundPolicyGroupItemSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.model.action.StdRefugritarchDaoSelect;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.model.checker.RefugritarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootRefugritarchSelect extends DeciTreeTemplateRead<RefugritarchInfo> {
	
	public RootRefugritarchSelect(DeciTreeOption<RefugritarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefugritarchInfo> buildCheckerHook(DeciTreeOption<RefugritarchInfo> option) {
		List<ModelChecker<RefugritarchInfo>> queue = new ArrayList<>();		
		ModelChecker<RefugritarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefugritarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefugritarchInfo>> buildActionsOnPassedHook(DeciTreeOption<RefugritarchInfo> option) {
		List<ActionStd<RefugritarchInfo>> actions = new ArrayList<>();
		
		ActionStd<RefugritarchInfo> select = new StdRefugritarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
