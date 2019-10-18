package br.com.gda.business.storeList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.storeList.model.action.LazyStolisMergeAddress;
import br.com.gda.business.storeList.model.action.LazyStolisMergeComp;
import br.com.gda.business.storeList.model.action.LazyStolisMergeCurrency;
import br.com.gda.business.storeList.model.action.LazyStolisMergePhone;
import br.com.gda.business.storeList.model.action.LazyStolisMergeTimezone;
import br.com.gda.business.storeList.model.action.StdStolisMergeToSelect;
import br.com.gda.business.storeList.model.checker.StolisCheckLangu;
import br.com.gda.business.storeList.model.checker.StolisCheckOwner;
import br.com.gda.business.storeList.model.checker.StolisCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;


public final class RootStolisSelect extends DeciTreeReadTemplate<StolisInfo> {
	
	public RootStolisSelect(DeciTreeOption<StolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StolisInfo> buildDecisionCheckerHook(DeciTreeOption<StolisInfo> option) {
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
	
	
	
	@Override protected List<ActionStd<StolisInfo>> buildActionsOnPassedHook(DeciTreeOption<StolisInfo> option) {
		List<ActionStd<StolisInfo>> actions = new ArrayList<>();

		ActionStd<StolisInfo> select = new StdStolisMergeToSelect(option);
		ActionLazy<StolisInfo> mergeCurrency = new LazyStolisMergeCurrency(option.conn, option.schemaName);
		ActionLazy<StolisInfo> mergeTimezone = new LazyStolisMergeTimezone(option.conn, option.schemaName);
		ActionLazy<StolisInfo> mergeCompany = new LazyStolisMergeComp(option.conn, option.schemaName);
		ActionLazy<StolisInfo> mergeAddress = new LazyStolisMergeAddress(option.conn, option.schemaName);
		ActionLazy<StolisInfo> mergePhone = new LazyStolisMergePhone(option.conn, option.schemaName);
		
		select.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeTimezone);
		mergeTimezone.addPostAction(mergeCompany);
		mergeCompany.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		
		actions.add(select);
		return actions;
	}
}
