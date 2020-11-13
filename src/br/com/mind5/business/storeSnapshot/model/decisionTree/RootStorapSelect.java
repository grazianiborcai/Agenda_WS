package br.com.mind5.business.storeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapMergeCurrency;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapMergePhonap;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapMergeTimezone;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapNodeCompnap;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapNodePersonap;
import br.com.mind5.business.storeSnapshot.model.action.StdStorapMergeToSelect;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckLangu;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckOwner;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;


public final class RootStorapSelect extends DeciTreeTemplateReadV2<StorapInfo> {
	
	public RootStorapSelect(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorapInfo> buildCheckerHook(DeciTreeOption<StorapInfo> option) {
		List<ModelCheckerV1<StorapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorapCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorapCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<StorapInfo>> buildActionsOnPassedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStdV2<StorapInfo>> actions = new ArrayList<>();

		ActionStdV2<StorapInfo> select = new StdStorapMergeToSelect(option);
		ActionLazy<StorapInfo> mergeCurrency = new LazyStorapMergeCurrency(option.conn, option.schemaName);
		ActionLazy<StorapInfo> mergeTimezone = new LazyStorapMergeTimezone(option.conn, option.schemaName); 
		ActionLazy<StorapInfo> mergePhonap = new LazyStorapMergePhonap(option.conn, option.schemaName);
		ActionLazy<StorapInfo> nodePersonap = new LazyStorapNodePersonap(option.conn, option.schemaName);
		ActionLazy<StorapInfo> nodeCompnap = new LazyStorapNodeCompnap(option.conn, option.schemaName);
		
		select.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeTimezone); 
		mergeTimezone.addPostAction(mergePhonap);
		mergePhonap.addPostAction(nodePersonap);
		nodePersonap.addPostAction(nodeCompnap);
		
		actions.add(select);
		return actions;
	}
}
