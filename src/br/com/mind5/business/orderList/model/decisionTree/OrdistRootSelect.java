package br.com.mind5.business.orderList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.action.OrdistVisiMergeCurrency;
import br.com.mind5.business.orderList.model.action.OrdistVisiMergeOrderatus;
import br.com.mind5.business.orderList.model.action.OrdistVisiMergeOrdereou;
import br.com.mind5.business.orderList.model.action.OrdistVisiMergeToSelect;
import br.com.mind5.business.orderList.model.checker.OrdistCheckLangu;
import br.com.mind5.business.orderList.model.checker.OrdistCheckOwner;
import br.com.mind5.business.orderList.model.checker.OrdistCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OrdistRootSelect extends DeciTreeTemplateRead<OrdistInfo> {
	
	public OrdistRootSelect(DeciTreeOption<OrdistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdistInfo> buildCheckerHook(DeciTreeOption<OrdistInfo> option) {
		List<ModelChecker<OrdistInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdistInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdistCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdistCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdistCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdistInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdistInfo> option) {
		List<ActionStd<OrdistInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdistInfo> select = new ActionStdCommom<OrdistInfo>(option, OrdistVisiMergeToSelect.class);
		ActionLazy<OrdistInfo> mergeCurrency = new ActionLazyCommom<OrdistInfo>(option, OrdistVisiMergeCurrency.class);
		ActionLazy<OrdistInfo> mergeOrderatus = new ActionLazyCommom<OrdistInfo>(option, OrdistVisiMergeOrderatus.class);
		ActionLazy<OrdistInfo> mergeOrdereou = new ActionLazyCommom<OrdistInfo>(option, OrdistVisiMergeOrdereou.class);
		
		select.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeOrderatus);
		mergeOrderatus.addPostAction(mergeOrdereou);
		
		actions.add(select);			
		return actions;
	}
}
