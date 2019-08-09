package br.com.gda.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.action.StdCompSuccess;
import br.com.gda.business.company.model.checker.CompCheckCnpjLength;
import br.com.gda.business.company.model.checker.CompCheckCnpjNumber;
import br.com.gda.business.company.model.checker.CompCheckCnpjOnlyNumber;
import br.com.gda.business.company.model.checker.CompCheckCnpjSequence;
import br.com.gda.business.company.model.checker.CompCheckExistCnpj;
import br.com.gda.business.company.model.checker.CompCheckHasCnpj;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeCompCnpj extends DeciTreeWriteTemplate<CompInfo> {
	
	public NodeCompCnpj(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompInfo> buildDecisionCheckerHook(DeciTreeOption<CompInfo> option) {
		final boolean DONT_EXIST_ON_DB = false;	
		
		List<ModelChecker<CompInfo>> queue = new ArrayList<>();		
		ModelChecker<CompInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CompCheckHasCnpj();
		queue.add(checker);
		
		checker = new CompCheckCnpjOnlyNumber();
		queue.add(checker);
		
		checker = new CompCheckCnpjLength();
		queue.add(checker);
		
		checker = new CompCheckCnpjSequence();
		queue.add(checker);
		
		checker = new CompCheckCnpjNumber();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new CompCheckExistCnpj(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CompInfo>> buildActionsOnPassedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStd<CompInfo>> actions = new ArrayList<>();
		
		ActionStd<CompInfo> success = new StdCompSuccess(option);
		actions.add(success);	
		return actions;
	}
}
