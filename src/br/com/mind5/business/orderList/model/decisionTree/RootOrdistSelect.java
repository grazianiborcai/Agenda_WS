package br.com.mind5.business.orderList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.action.LazyOrdistMergeCurrency;
import br.com.mind5.business.orderList.model.action.LazyOrdistMergeOrderStatus;
import br.com.mind5.business.orderList.model.action.StdOrdistMergeToSelect;
import br.com.mind5.business.orderList.model.checker.OrdistCheckLangu;
import br.com.mind5.business.orderList.model.checker.OrdistCheckOwner;
import br.com.mind5.business.orderList.model.checker.OrdistCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootOrdistSelect extends DeciTreeReadTemplate<OrdistInfo> {
	
	public RootOrdistSelect(DeciTreeOption<OrdistInfo> option) {
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrdistInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdistInfo> option) {
		List<ActionStdV1<OrdistInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<OrdistInfo> select = new StdOrdistMergeToSelect(option);
		ActionLazyV1<OrdistInfo> mergeCurrency = new LazyOrdistMergeCurrency(option.conn, option.schemaName);
		ActionLazyV1<OrdistInfo> mergeOrderStatus = new LazyOrdistMergeOrderStatus(option.conn, option.schemaName);
		
		select.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeOrderStatus);
		
		actions.add(select);			
		return actions;
	}
}
