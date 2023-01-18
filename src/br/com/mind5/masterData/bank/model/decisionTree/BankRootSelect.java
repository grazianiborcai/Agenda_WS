package br.com.mind5.masterData.bank.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.bank.info.BankInfo;
import br.com.mind5.masterData.bank.model.action.BankVisiDaoSelect;
import br.com.mind5.masterData.bank.model.action.BankVisiMergeCountry;
import br.com.mind5.masterData.bank.model.checker.BankCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class BankRootSelect extends DeciTreeTemplateRead<BankInfo> {
	
	public BankRootSelect(DeciTreeOption<BankInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BankInfo> buildCheckerHook(DeciTreeOption<BankInfo> option) {
		List<ModelChecker<BankInfo>> queue = new ArrayList<>();		
		ModelChecker<BankInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BankCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<BankInfo>> buildActionsOnPassedHook(DeciTreeOption<BankInfo> option) {
		List<ActionStd<BankInfo>> actions = new ArrayList<>();
		
		ActionStd<BankInfo> select = new ActionStdCommom<BankInfo>(option, BankVisiDaoSelect.class);
		ActionLazy<BankInfo> mergeContry = new ActionLazyCommom<BankInfo>(option, BankVisiMergeCountry.class);
		
		select.addPostAction(mergeContry);
		
		actions.add(select);
		return actions;
	}
}
