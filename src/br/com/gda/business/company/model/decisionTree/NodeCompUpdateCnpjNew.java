package br.com.gda.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.checker.CompCheckCnpjNew;
import br.com.gda.business.company.model.checker.CompCheckHasCnpj;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeCompUpdateCnpjNew extends DeciTreeWriteTemplate<CompInfo> {
	
	public NodeCompUpdateCnpjNew(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompInfo> buildDecisionCheckerHook(DeciTreeOption<CompInfo> option) {
		final boolean BLANK_TO_FILLED = true;	
		
		List<ModelChecker<CompInfo>> queue = new ArrayList<>();		
		ModelChecker<CompInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CompCheckHasCnpj();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = BLANK_TO_FILLED;		
		checker = new CompCheckCnpjNew(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CompInfo>> buildActionsOnPassedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStd<CompInfo>> actions = new ArrayList<>();
		
		ActionStd<CompInfo> nodeCnpj = new NodeCompCnpj(option).toAction();	
		actions.add(nodeCnpj);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CompInfo>> buildActionsOnFailedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStd<CompInfo>> actions = new ArrayList<>();
		
		ActionStd<CompInfo> nodeCnpj = new NodeCompUpdateCnpjOld(option).toAction();	
		actions.add(nodeCnpj);	
		return actions;
	}
}
