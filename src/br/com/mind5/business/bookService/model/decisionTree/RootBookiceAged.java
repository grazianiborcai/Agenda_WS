package br.com.mind5.business.bookService.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.model.checker.BookiceCheckServiceCartem;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootBookiceAged extends DeciTreeTemplateWrite<BookiceInfo> {
	
	public RootBookiceAged(DeciTreeOption<BookiceInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BookiceInfo> buildCheckerHook(DeciTreeOption<BookiceInfo> option) {
		List<ModelChecker<BookiceInfo>> queue = new ArrayList<>();		
		ModelChecker<BookiceInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BookiceCheckServiceCartem(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BookiceInfo>> buildActionsOnPassedHook(DeciTreeOption<BookiceInfo> option) {
		List<ActionStd<BookiceInfo>> actions = new ArrayList<>();
		
		ActionStd<BookiceInfo> nodeL1 = new NodeBookiceAgedL01(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
