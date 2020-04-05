package br.com.mind5.business.storeList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.action.LazyStolisMergeAddress;
import br.com.mind5.business.storeList.model.action.LazyStolisMergeComplis;
import br.com.mind5.business.storeList.model.action.LazyStolisMergeCurrency;
import br.com.mind5.business.storeList.model.action.LazyStolisMergeFimist;
import br.com.mind5.business.storeList.model.action.LazyStolisMergePhone;
import br.com.mind5.business.storeList.model.action.LazyStolisMergeTimezone;
import br.com.mind5.business.storeList.model.action.StdStolisMergeToSelect;
import br.com.mind5.business.storeList.model.checker.StolisCheckLangu;
import br.com.mind5.business.storeList.model.checker.StolisCheckOwner;
import br.com.mind5.business.storeList.model.checker.StolisCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;


public final class RootStolisSelect extends DeciTreeReadTemplate<StolisInfo> {
	
	public RootStolisSelect(DeciTreeOption<StolisInfo> option) {
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StolisInfo>> buildActionsOnPassedHook(DeciTreeOption<StolisInfo> option) {
		List<ActionStdV1<StolisInfo>> actions = new ArrayList<>();

		ActionStdV1<StolisInfo> select = new StdStolisMergeToSelect(option);
		ActionLazyV1<StolisInfo> mergeCurrency = new LazyStolisMergeCurrency(option.conn, option.schemaName);
		ActionLazyV1<StolisInfo> mergeTimezone = new LazyStolisMergeTimezone(option.conn, option.schemaName);
		ActionLazyV1<StolisInfo> mergeComplis = new LazyStolisMergeComplis(option.conn, option.schemaName);
		ActionLazyV1<StolisInfo> mergeAddress = new LazyStolisMergeAddress(option.conn, option.schemaName);
		ActionLazyV1<StolisInfo> mergePhone = new LazyStolisMergePhone(option.conn, option.schemaName);
		ActionLazyV1<StolisInfo> mergeFimist = new LazyStolisMergeFimist(option.conn, option.schemaName);
		
		select.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeTimezone);
		mergeTimezone.addPostAction(mergeComplis);
		mergeComplis.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
