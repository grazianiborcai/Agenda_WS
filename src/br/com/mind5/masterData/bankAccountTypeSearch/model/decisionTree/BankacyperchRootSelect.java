package br.com.mind5.masterData.bankAccountTypeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.bankAccountTypeSearch.info.BankacyperchInfo;
import br.com.mind5.masterData.bankAccountTypeSearch.model.action.BankacyperchVisiDaoSelect;
import br.com.mind5.masterData.bankAccountTypeSearch.model.checker.BankacyperchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class BankacyperchRootSelect extends DeciTreeTemplateRead<BankacyperchInfo> {
	
	public BankacyperchRootSelect(DeciTreeOption<BankacyperchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BankacyperchInfo> buildCheckerHook(DeciTreeOption<BankacyperchInfo> option) {
		List<ModelChecker<BankacyperchInfo>> queue = new ArrayList<>();		
		ModelChecker<BankacyperchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BankacyperchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<BankacyperchInfo>> buildActionsOnPassedHook(DeciTreeOption<BankacyperchInfo> option) {
		List<ActionStd<BankacyperchInfo>> actions = new ArrayList<>();
		
		ActionStd<BankacyperchInfo> select = new ActionStdCommom<BankacyperchInfo>(option, BankacyperchVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
