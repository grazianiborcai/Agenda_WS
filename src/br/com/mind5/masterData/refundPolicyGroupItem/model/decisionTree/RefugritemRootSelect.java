package br.com.mind5.masterData.refundPolicyGroupItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.masterData.refundPolicyGroupItem.model.action.RefugritemVisiDaoSelect;
import br.com.mind5.masterData.refundPolicyGroupItem.model.action.RefugritemVisiMergeRefupo;
import br.com.mind5.masterData.refundPolicyGroupItem.model.checker.RefugritemCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RefugritemRootSelect extends DeciTreeTemplateRead<RefugritemInfo> {
	
	public RefugritemRootSelect(DeciTreeOption<RefugritemInfo> option) {
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
		
		ActionStd<RefugritemInfo> select = new ActionStdCommom<RefugritemInfo>(option, RefugritemVisiDaoSelect.class);
		ActionLazy<RefugritemInfo> mergeRefupo = new ActionLazyCommom<RefugritemInfo>(option, RefugritemVisiMergeRefupo.class);
		
		select.addPostAction(mergeRefupo);
		
		actions.add(select);
		return actions;
	}
}
