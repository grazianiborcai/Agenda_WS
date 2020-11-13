package br.com.mind5.masterData.refundPolicyGroupItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.masterData.refundPolicyGroupItem.model.action.LazyRefugritemMergeRefupo;
import br.com.mind5.masterData.refundPolicyGroupItem.model.action.StdRefugritemDaoSelect;
import br.com.mind5.masterData.refundPolicyGroupItem.model.checker.RefugritemCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootRefugritemSelect extends DeciTreeTemplateRead<RefugritemInfo> {
	
	public RootRefugritemSelect(DeciTreeOption<RefugritemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefugritemInfo> buildCheckerHook(DeciTreeOption<RefugritemInfo> option) {
		List<ModelChecker<RefugritemInfo>> queue = new ArrayList<>();		
		ModelChecker<RefugritemInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefugritemCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefugritemInfo>> buildActionsOnPassedHook(DeciTreeOption<RefugritemInfo> option) {
		List<ActionStd<RefugritemInfo>> actions = new ArrayList<>();
		
		ActionStd<RefugritemInfo> select = new StdRefugritemDaoSelect(option);
		ActionLazy<RefugritemInfo> mergeRefupo = new LazyRefugritemMergeRefupo(option.conn, option.schemaName);
		
		select.addPostAction(mergeRefupo);
		
		actions.add(select);
		return actions;
	}
}
