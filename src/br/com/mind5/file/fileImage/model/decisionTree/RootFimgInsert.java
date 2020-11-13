package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgRootSelect;
import br.com.mind5.file.fileImage.model.action.LazyFimgWriteOnDisk;
import br.com.mind5.file.fileImage.model.checker.FimgCheckLangu;
import br.com.mind5.file.fileImage.model.checker.FimgCheckOwner;
import br.com.mind5.file.fileImage.model.checker.FimgCheckReference;
import br.com.mind5.file.fileImage.model.checker.FimgCheckInsert;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootFimgInsert extends DeciTreeTemplateWriteV2<FimgInfo> {
	
	public RootFimgInsert(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelCheckerV1<FimgInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FimgInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgCheckReference(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimgCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimgCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStdV1<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<FimgInfo> coverOff = new NodeFimgCoverOffL1(option).toAction();
		ActionStdV1<FimgInfo> insert = new NodeFimgInsert(option).toAction();	
		ActionLazy<FimgInfo> writeOnDisk = new LazyFimgWriteOnDisk(option.conn, option.schemaName);
		ActionLazy<FimgInfo> select = new LazyFimgRootSelect(option.conn, option.schemaName);
		
		insert.addPostAction(writeOnDisk);
		writeOnDisk.addPostAction(select);
		
		actions.add(coverOff);
		actions.add(insert);		
		return actions;
	}
}
