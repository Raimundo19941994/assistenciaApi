select * from ordem;
insert into ordem(data_abertura,data_entrada, defeito, total_servico, total_pecas, total_ordem, funcionarios_id, clientes_id, aparelho_id)
values('2024-01-01','2024-01-02','placa','300','200','500', '1', '1', '1'),
	 ('2024-02-03','2024-02-04','tela','400','100','500', '2', '2', '2'),
     ('2024-03-05','2024-03-06','formatacao','150','50','200', '3', '3', '3'),
     ('2024-05-03','2024-05-04','placa e hd','200','400','600', '4', '4', '4'),
     ('2024-07-11','2024-07-12','cooler','100','50','150', '5', '5', '5');



#DELETE FROM `assistencia`.`ordem` WHERE (`id` = '5');


