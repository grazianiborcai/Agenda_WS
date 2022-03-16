package br.com.mind5.business.storeList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.action.StolisVisiMergeAddress;
import br.com.mind5.business.storeList.model.action.StolisVisiMergeComplis;
import br.com.mind5.business.storeList.model.action.StolisVisiMergeCurrency;
import br.com.mind5.business.storeList.model.action.StolisVisiMergeFimeco;
import br.com.mind5.business.storeList.model.action.StolisVisiMergePhone;
import br.com.mind5.business.storeList.model.action.StolisVisiMergeStorac;
import br.com.mind5.business.storeList.model.action.StolisVisiMergeStorext;
import br.com.mind5.business.storeList.model.action.StolisVisiMergeTimezone;
import br.com.mind5.business.storeList.model.action.StolisVisiMergeToSelect;
import br.com.mind5.business.storeList.model.checker.StolisCheckLangu;
import br.com.mind5.business.storeList.model.checker.StolisCheckOwner;
import br.com.mind5.business.storeList.model.checker.StolisCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;


public final class StolisRootSelect extends DeciTreeTemplateWrite<StolisInfo> {
	
	public StolisRootSelect(DeciTreeOption<StolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StolisInfo> buildCheckerHook(DeciTreeOption<StolisInfo> option) {
		List<ModelChecker<StolisInfo>> queue = new ArrayList<>();		
		ModelChecker<StolisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StolisCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolisCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolisCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolisInfo>> buildActionsOnPassedHook(DeciTreeOption<StolisInfo> option) {
		List<ActionStd<StolisInfo>> actions = new ArrayList<>();

		ActionStd<StolisInfo> select = new ActionStdCommom<StolisInfo>(option, StolisVisiMergeToSelect.class);
		ActionLazy<StolisInfo> mergeCurrency = new ActionLazyCommom<StolisInfo>(option.conn, option.schemaName, StolisVisiMergeCurrency.class);
		ActionLazy<StolisInfo> mergeTimezone = new ActionLazyCommom<StolisInfo>(option.conn, option.schemaName, StolisVisiMergeTimezone.class);
		ActionLazy<StolisInfo> mergeComplis = new ActionLazyCommom<StolisInfo>(option.conn, option.schemaName, StolisVisiMergeComplis.class);
		ActionLazy<StolisInfo> mergeAddress = new ActionLazyCommom<StolisInfo>(option.conn, option.schemaName, StolisVisiMergeAddress.class);
		ActionLazy<StolisInfo> mergePhone = new ActionLazyCommom<StolisInfo>(option.conn, option.schemaName, StolisVisiMergePhone.class);
		ActionLazy<StolisInfo> mergeFimeco = new ActionLazyCommom<StolisInfo>(option.conn, option.schemaName, StolisVisiMergeFimeco.class);
		ActionLazy<StolisInfo> mergeStorext = new ActionLazyCommom<StolisInfo>(option.conn, option.schemaName, StolisVisiMergeStorext.class);
		ActionLazy<StolisInfo> mergeStorac = new ActionLazyCommom<StolisInfo>(option.conn, option.schemaName, StolisVisiMergeStorac.class);
		
		select.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeTimezone);
		mergeTimezone.addPostAction(mergeComplis);
		mergeComplis.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeFimeco);
		mergeFimeco.addPostAction(mergeStorext);
		mergeStorext.addPostAction(mergeStorac);
		
		actions.add(select);
		return actions;
	}
}
