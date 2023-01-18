package br.com.mind5.masterData.bankHolderType.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.bankHolderType.info.BankoldypeInfo;
import br.com.mind5.masterData.bankHolderType.model.action.BankoldypeVisiDaoSelect;
import br.com.mind5.masterData.bankHolderType.model.checker.BankoldypeCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class BankoldypeRootSelect extends DeciTreeTemplateRead<BankoldypeInfo> {
	
	public BankoldypeRootSelect(DeciTreeOption<BankoldypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BankoldypeInfo> buildCheckerHook(DeciTreeOption<BankoldypeInfo> option) {
		List<ModelChecker<BankoldypeInfo>> queue = new ArrayList<>();		
		ModelChecker<BankoldypeInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BankoldypeCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<BankoldypeInfo>> buildActionsOnPassedHook(DeciTreeOption<BankoldypeInfo> option) {
		List<ActionStd<BankoldypeInfo>> actions = new ArrayList<>();
		
		ActionStd<BankoldypeInfo> select = new ActionStdCommom<BankoldypeInfo>(option, BankoldypeVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
