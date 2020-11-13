package br.com.mind5.business.orderList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.action.LazyOrdistMergeCurrency;
import br.com.mind5.business.orderList.model.action.LazyOrdistMergeOrderatus;
import br.com.mind5.business.orderList.model.action.StdOrdistMergeToSelect;
import br.com.mind5.business.orderList.model.checker.OrdistCheckLangu;
import br.com.mind5.business.orderList.model.checker.OrdistCheckOwner;
import br.com.mind5.business.orderList.model.checker.OrdistCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootOrdistSelect extends DeciTreeTemplateReadV2<OrdistInfo> {
	
	public RootOrdistSelect(DeciTreeOption<OrdistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrdistInfo> buildCheckerHook(DeciTreeOption<OrdistInfo> option) {
		List<ModelCheckerV1<OrdistInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrdistInfo> checker;	
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OrdistInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdistInfo> option) {
		List<ActionStdV2<OrdistInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<OrdistInfo> select = new StdOrdistMergeToSelect(option);
		ActionLazy<OrdistInfo> mergeCurrency = new LazyOrdistMergeCurrency(option.conn, option.schemaName);
		ActionLazy<OrdistInfo> mergeOrderatus = new LazyOrdistMergeOrderatus(option.conn, option.schemaName);
		
		select.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeOrderatus);
		
		actions.add(select);			
		return actions;
	}
}
