package br.com.mind5.business.storeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.action.StorapVisiNodeCompnap;
import br.com.mind5.business.storeSnapshot.model.action.StorapVisiNodePersonap;
import br.com.mind5.business.storeSnapshot.model.action.StorapVisiMergeCurrency;
import br.com.mind5.business.storeSnapshot.model.action.StorapVisiMergePhonap;
import br.com.mind5.business.storeSnapshot.model.action.StorapVisiMergeTimezone;
import br.com.mind5.business.storeSnapshot.model.action.StorapVisiMergeToSelect;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckLangu;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckOwner;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class StorapRootSelect extends DeciTreeTemplateRead<StorapInfo> {
	
	public StorapRootSelect(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorapInfo> buildCheckerHook(DeciTreeOption<StorapInfo> option) {
		List<ModelChecker<StorapInfo>> queue = new ArrayList<>();		
		ModelChecker<StorapInfo> checker;
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorapInfo>> buildActionsOnPassedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStd<StorapInfo>> actions = new ArrayList<>();

		ActionStd<StorapInfo> select = new ActionStdCommom<StorapInfo>(option, StorapVisiMergeToSelect.class);
		ActionLazy<StorapInfo> mergeCurrency = new  ActionLazyCommom<StorapInfo>(option, StorapVisiMergeCurrency.class);
		ActionLazy<StorapInfo> mergeTimezone = new ActionLazyCommom<StorapInfo>(option, StorapVisiMergeTimezone.class); 
		ActionLazy<StorapInfo> mergePhonap = new ActionLazyCommom<StorapInfo>(option, StorapVisiMergePhonap.class);
		ActionLazy<StorapInfo> nodePersonap = new ActionLazyCommom<StorapInfo>(option, StorapVisiNodePersonap.class);
		ActionLazy<StorapInfo> nodeCompnap = new ActionLazyCommom<StorapInfo>(option, StorapVisiNodeCompnap.class);
		
		select.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeTimezone); 
		mergeTimezone.addPostAction(mergePhonap);
		mergePhonap.addPostAction(nodePersonap);
		nodePersonap.addPostAction(nodeCompnap);
		
		actions.add(select);
		return actions;
	}
}
