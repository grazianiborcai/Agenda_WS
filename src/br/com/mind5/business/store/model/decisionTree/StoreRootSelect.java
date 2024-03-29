package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StoreVisiMergeAddress;
import br.com.mind5.business.store.model.action.StoreVisiMergeBankacc;
import br.com.mind5.business.store.model.action.StoreVisiMergeComp;
import br.com.mind5.business.store.model.action.StoreVisiMergeCurrency;
import br.com.mind5.business.store.model.action.StoreVisiMergeFimeco;
import br.com.mind5.business.store.model.action.StoreVisiMergeMatore;
import br.com.mind5.business.store.model.action.StoreVisiMergePhone;
import br.com.mind5.business.store.model.action.StoreVisiMergeStefilon;
import br.com.mind5.business.store.model.action.StoreVisiMergeStorac;
import br.com.mind5.business.store.model.action.StoreVisiMergeStorext;
import br.com.mind5.business.store.model.action.StoreVisiMergeStowotm;
import br.com.mind5.business.store.model.action.StoreVisiMergeStuntm;
import br.com.mind5.business.store.model.action.StoreVisiMergeTimezone;
import br.com.mind5.business.store.model.action.StoreVisiMergeToSelect;
import br.com.mind5.business.store.model.action.StoreVisiMergeUser;
import br.com.mind5.business.store.model.action.StoreVisiNodePereg;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.business.store.model.checker.StoreCheckLangu;
import br.com.mind5.business.store.model.checker.StoreCheckRead;
import br.com.mind5.business.store.model.checker.StoreCheckStorauth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class StoreRootSelect extends DeciTreeTemplateRead<StoreInfo> {
	
	public StoreRootSelect(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StoreCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckStorauth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();

		ActionStd <StoreInfo> select        = new ActionStdCommom <StoreInfo>(option, StoreVisiMergeToSelect.class);
		ActionLazy<StoreInfo> mergeCurrency = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergeCurrency.class);
		ActionLazy<StoreInfo> mergeTimezone = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergeTimezone.class);
		ActionLazy<StoreInfo> mergeComp     = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergeComp.class);
		ActionLazy<StoreInfo> mergeAddress  = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergeAddress.class);
		ActionLazy<StoreInfo> mergePhone    = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergePhone.class);
		ActionLazy<StoreInfo> mergeFimeco   = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergeFimeco.class);
		ActionLazy<StoreInfo> mergeStorext  = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergeStorext.class);
		ActionLazy<StoreInfo> mergeStorac   = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergeStorac.class);
		ActionLazy<StoreInfo> mergeStefilon = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergeStefilon.class);
		ActionLazy<StoreInfo> mergeStowotm  = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergeStowotm.class);
		ActionLazy<StoreInfo> mergeStuntm   = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergeStuntm.class);
		ActionLazy<StoreInfo> mergeMatore   = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergeMatore.class);
		ActionLazy<StoreInfo> nodePereg     = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodePereg.class);
		ActionLazy<StoreInfo> mergeUser     = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergeUser.class);
		ActionLazy<StoreInfo> mergeBankacc  = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergeBankacc.class);
		
		select.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeTimezone);
		mergeTimezone.addPostAction(mergeComp);
		mergeComp.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeFimeco);
		mergeFimeco.addPostAction(mergeStorext);
		mergeStorext.addPostAction(mergeStorac);
		mergeStorac.addPostAction(mergeStefilon);
		mergeStefilon.addPostAction(mergeStowotm);
		mergeStowotm.addPostAction(mergeStuntm);
		mergeStuntm.addPostAction(mergeMatore);
		mergeMatore.addPostAction(nodePereg);
		nodePereg.addPostAction(mergeUser);
		mergeUser.addPostAction(mergeBankacc);
		
		actions.add(select);
		return actions;
	}
}
