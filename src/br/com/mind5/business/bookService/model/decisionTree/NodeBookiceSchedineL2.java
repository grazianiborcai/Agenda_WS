package br.com.mind5.business.bookService.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.model.action.StdBookiceSuccess;
import br.com.mind5.business.bookService.model.checker.BookiceCheckCarterve;
import br.com.mind5.business.bookService.model.checker.BookiceCheckEmp;
import br.com.mind5.business.bookService.model.checker.BookiceCheckEmplarg;
import br.com.mind5.business.bookService.model.checker.BookiceCheckEmpmat;
import br.com.mind5.business.bookService.model.checker.BookiceCheckEmpworg;
import br.com.mind5.business.bookService.model.checker.BookiceCheckMat;
import br.com.mind5.business.bookService.model.checker.BookiceCheckMatore;
import br.com.mind5.business.bookService.model.checker.BookiceCheckOrderve;
import br.com.mind5.business.bookService.model.checker.BookiceCheckPlanarch;
import br.com.mind5.business.bookService.model.checker.BookiceCheckSchedarch;
import br.com.mind5.business.bookService.model.checker.BookiceCheckStolarg;
import br.com.mind5.business.bookService.model.checker.BookiceCheckStore;
import br.com.mind5.business.bookService.model.checker.BookiceCheckStoworg;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeBookiceSchedineL2 extends DeciTreeTemplateWrite<BookiceInfo> {
	
	public NodeBookiceSchedineL2(DeciTreeOption<BookiceInfo> option) {
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
		checker = new BookiceCheckMat(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BookiceCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BookiceCheckMatore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BookiceCheckEmp(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BookiceCheckEmpmat(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BookiceCheckStoworg(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BookiceCheckEmpworg(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new BookiceCheckEmplarg(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new BookiceCheckStolarg(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new BookiceCheckOrderve(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BookiceCheckPlanarch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new BookiceCheckCarterve(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new BookiceCheckSchedarch(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BookiceInfo>> buildActionsOnPassedHook(DeciTreeOption<BookiceInfo> option) {
		List<ActionStd<BookiceInfo>> actions = new ArrayList<>();
		
		ActionStd<BookiceInfo> success = new StdBookiceSuccess(option);			
		actions.add(success);
		
		return actions;
	}
}
