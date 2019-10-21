package br.com.mind5.business.orderList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.action.LazyOrdistMergeCurrency;
import br.com.mind5.business.orderList.model.action.LazyOrdistMergeOrderStatus;
import br.com.mind5.business.orderList.model.action.StdOrdistMergeToSelect;
import br.com.mind5.business.orderList.model.checker.OrdistCheckLangu;
import br.com.mind5.business.orderList.model.checker.OrdistCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootOrdistSelect extends DeciTreeReadTemplate<OrdistInfo> {
	
	public RootOrdistSelect(DeciTreeOption<OrdistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdistInfo> buildDecisionCheckerHook(DeciTreeOption<OrdistInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrdistInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdistInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrdistCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdistCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdistInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdistInfo> option) {
		List<ActionStd<OrdistInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdistInfo> select = new StdOrdistMergeToSelect(option);
		ActionLazy<OrdistInfo> mergeCurrency = new LazyOrdistMergeCurrency(option.conn, option.schemaName);
		ActionLazy<OrdistInfo> mergeOrderStatus = new LazyOrdistMergeOrderStatus(option.conn, option.schemaName);
		
		select.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeOrderStatus);
		
		actions.add(select);			
		return actions;
	}
}
