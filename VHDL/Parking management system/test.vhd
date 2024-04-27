library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.STD_LOGIC_unsigned.all;

entity nr_cresc_descresc is
	port( clk,cd1,cd2, cu1,cu2 , reset: in std_logic;
	    x: in std_logic_vector(7 downto 0);
		Qout: out std_logic_vector(7 downto 0));
end nr_cresc_descresc;

architecture nr_cresc_descresc of nr_cresc_descresc is	  
	
	signal carry: std_logic := '0';
	signal q: std_logic_vector(7 downto 0);
begin
	Qout <= q;
	process(clk, reset)
	begin
		if reset = '1' then q <= x;
		elsif clk = '1' and clk'event then
			if cu1 = '1' then
				if q = x then
					null;
				else
					q <= q + '1'; 
				end if;	
			end if;
			if cu2 = '1' then
				if q = x then
					null;
				else
					q <= q + '1'; 
				end if;	
			end if;
			if cd1 = '1' then
				if q = "0" then
					null ;
				else
					q <= q - '1';	
				end if;	
			end if;
			if cd2 = '1' then
				if q = "0" then
					null ;
				else
					q <= q - '1';	
				end if;	
			end if;
			
		end if;
	end process;
end nr_cresc_descresc;
