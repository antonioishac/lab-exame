package br.com.labexame.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Laboratorio.class)
public abstract class Laboratorio_ {

	public static volatile SingularAttribute<Laboratorio, Long> id;
	public static volatile SingularAttribute<Laboratorio, String> nome;
	public static volatile SingularAttribute<Laboratorio, Status> status;
	public static volatile ListAttribute<Laboratorio, Endereco> enderecos;

}
