package br.com.mind5.masterData.refundPolicyGroupSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;
import br.com.mind5.masterData.refundPolicyGroupSearch.model.action.StdRefugrarchDaoSelect;
import br.com.mind5.masterData.refundPolicyGroupSearch.model.checker.RefugrarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootRefugrarchSelect extends DeciTreeTemplateRead<RefugrarchInfo> {
	
	public RootRefugrarchSelect(DeciTreeOption<RefugrarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefugrarchInfo> buildCheckerHook(DeciTreeOption<RefugrarchInfo> option) {
		List<ModelChecker<RefugrarchInfo>> queue = new ArrayList<>();		
		ModelChecker<RefugrarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefugrarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefugrarchInfo>> buildActionsOnPassedHook(DeciTreeOption<RefugrarchInfo> option) {
		List<ActionStd<RefugrarchInfo>> actions = new ArrayList<>();
		
		ActionStd<RefugrarchInfo> select = new StdRefugrarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
