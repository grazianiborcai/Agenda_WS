package br.com.mind5.business.bookService.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.model.action.LazyBookiceEnforceAged;
import br.com.mind5.business.bookService.model.action.LazyBookiceMergeSymsg;
import br.com.mind5.business.bookService.model.action.StdBookiceEnforceSymsgL02;
import br.com.mind5.business.bookService.model.checker.BookiceCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeBookiceAgedL02 extends DeciTreeTemplateWrite<BookiceInfo> {
	
	public NodeBookiceAgedL02(DeciTreeOption<BookiceInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BookiceInfo> buildCheckerHook(DeciTreeOption<BookiceInfo> option) {
		List<ModelChecker<BookiceInfo>> queue = new ArrayList<>();		
		ModelChecker<BookiceInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BookiceCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BookiceInfo>> buildActionsOnPassedHook(DeciTreeOption<BookiceInfo> option) {
		List<ActionStd<BookiceInfo>> actions = new ArrayList<>();
		
		ActionStd<BookiceInfo> nodeL03 = new NodeBookiceAgedL03(option).toAction();	
		
		actions.add(nodeL03);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<BookiceInfo>> buildActionsOnFailedHook(DeciTreeOption<BookiceInfo> option) {
		List<ActionStd<BookiceInfo>> actions = new ArrayList<>();
		
		ActionStd<BookiceInfo> enforceSymsg = new StdBookiceEnforceSymsgL02(option);	
		ActionLazy<BookiceInfo> mergeSymsg = new LazyBookiceMergeSymsg(option.conn, option.schemaName);
		ActionLazy<BookiceInfo> enforceAged = new LazyBookiceEnforceAged(option.conn, option.schemaName);
		
		enforceSymsg.addPostAction(mergeSymsg);
		mergeSymsg.addPostAction(enforceAged);
		
		actions.add(enforceSymsg);		
		return actions;
	}
}
