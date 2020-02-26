abstract org.fulib.scenarios.ast.Node { Positioned {
	// ...
	abstract decl.Decl(readonly name: String, readonly type: Type) {
		VarDecl(name: String, type: Type, expr: Expr)
		// ...
	}

	abstract decl.Name(readonly value: String) {
		// ...
		ResolvedName(decl: Decl)
	}

	abstract sentence.Sentence {
		// ...
		IsSentence(descriptor: VarDecl)
		HasSentence(object: Expr, clauses: [NamedExpr])
	}

	abstract expr.Expr {
		// ...
		NameAccess(name: Name)
		CreationExpr(type: Type, attributes: [NamedExpr])
	}
}}
