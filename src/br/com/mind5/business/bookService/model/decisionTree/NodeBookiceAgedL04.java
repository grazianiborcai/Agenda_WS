package br.com.mind5.business.bookService.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.model.action.LazyBookiceEnforceAged;
import br.com.mind5.business.bookService.model.action.LazyBookiceMergeSymsg;
import br.com.mind5.business.bookService.model.action.StdBookiceEnforceSymsgL04;
import br.com.mind5.business.bookService.model.checker.BookiceCheckMatore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeBookiceAgedL04 extends DeciTreeTemplateWriteV2<BookiceInfo> {
	
	public NodeBookiceAgedL04(DeciTreeOption<BookiceInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<BookiceInfo> buildCheckerHook(DeciTreeOption<BookiceInfo> option) {
		List<ModelCheckerV1<BookiceInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<BookiceInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BookiceCheckMatore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<BookiceInfo>> buildActionsOnPassedHook(DeciTreeOption<BookiceInfo> option) {
		List<ActionStdV2<BookiceInfo>> actions = new ArrayList<>();
		
		ActionStdV2<BookiceInfo> nodeL05 = new NodeBookiceAgedL05(option).toAction();	
		
		actions.add(nodeL05);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<BookiceInfo>> buildActionsOnFailedHook(DeciTreeOption<BookiceInfo> option) {
		List<ActionStdV2<BookiceInfo>> actions = new ArrayList<>();
		
		ActionStdV2<BookiceInfo> enforceSymsg = new StdBookiceEnforceSymsgL04(option);	
		ActionLazy<BookiceInfo> mergeSymsg = new LazyBookiceMergeSymsg(option.conn, option.schemaName);
		ActionLazy<BookiceInfo> enforceAged = new LazyBookiceEnforceAged(option.conn, option.schemaName);
		
		enforceSymsg.addPostAction(mergeSymsg);
		mergeSymsg.addPostAction(enforceAged);
		
		actions.add(enforceSymsg);		
		return actions;
	}
}
