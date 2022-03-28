package br.com.mind5.business.orderItemList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderItemList.model.action.OrdemistVisiMergeMatlis;
import br.com.mind5.business.orderItemList.model.action.OrdemistVisiMergeOrdist;
import br.com.mind5.business.orderItemList.model.action.OrdemistVisiMergeToSelect;
import br.com.mind5.business.orderItemList.model.checker.OrdemistCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrdemistRootSelect extends DeciTreeTemplateWrite<OrdemistInfo> {
	
	public OrdemistRootSelect(DeciTreeOption<OrdemistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdemistInfo> buildCheckerHook(DeciTreeOption<OrdemistInfo> option) {
		List<ModelChecker<OrdemistInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdemistInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new OrdemistCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdemistInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdemistInfo> option) {
		List<ActionStd<OrdemistInfo>> actions = new ArrayList<>();
		
		ActionStd<OrdemistInfo> select = new ActionStdCommom<OrdemistInfo>(option, OrdemistVisiMergeToSelect.class);
		ActionLazy<OrdemistInfo> mergeOrdist = new ActionLazyCommom<OrdemistInfo>(option, OrdemistVisiMergeOrdist.class);
		ActionLazy<OrdemistInfo> mergeMatlis = new ActionLazyCommom<OrdemistInfo>(option, OrdemistVisiMergeMatlis.class);
		
		select.addPostAction(mergeOrdist);
		mergeOrdist.addPostAction(mergeMatlis);
		
		actions.add(select);
		return actions;
	}
}
