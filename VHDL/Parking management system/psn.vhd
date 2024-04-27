library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.std_logic_unsigned.all; 

entity STARI is
port 
(
  clk,reset_n: in std_logic; 
  s1, s2: in std_logic_vector(3 downto 0);
  CARRY: out std_logic_vector(3 downto 0):="0000");  
end STARI;

architecture ss of STARI is
type p_Stari is (WAIT_CAR,CAR_EN,ISCAR,CAR_OUT,STOP);
signal current_state0,current_state1,current_state2,current_state3,next_state0,next_state1,next_state2,next_state3: p_Stari;

begin
process(clk,reset_n)
begin		  
 if(reset_n='1') then
  current_state0 <= WAIT_CAR;
  current_state1 <= WAIT_CAR;
  current_state2 <= WAIT_CAR;
  current_state3 <= WAIT_CAR;
 elsif(rising_edge(clk)) then
  current_state0 <= next_state0;
  current_state1 <= next_state1;
  current_state2 <= next_state2;
  current_state3 <= next_state3;
 end if;
end process; 

INTARE1:process(current_state0,s1,s2)
 begin
 case current_state0 is 
 when WAIT_CAR => 
 CARRY(0)<='0';
 if(S1(0) = '1' AND S2(0)='0') then 
  next_state0 <= CAR_EN; 
 else
  next_state0 <= WAIT_CAR;
 end if;
 when CAR_EN =>
 if(S1(0)='1' AND S2(0) = '1') then 
  next_state0 <= ISCAR;
 else
  next_state0 <= CAR_EN;
 end if;	   
 when ISCAR =>
 if(S1(0) = '0' AND S2(0) = '1') then 
  next_state0 <= CAR_OUT;
 else
  next_state0 <= ISCAR;
 end if; 
 when CAR_OUT =>
 if(S1(0) = '0' AND S2(0) = '0') then 
  next_state0 <= STOP;
 else
  next_state0 <= CAR_OUT;
 end if;
when STOP =>
  CARRY(0)<='1';
 next_state0 <= WAIT_CAR;
 when others => next_state0 <= WAIT_CAR;
 end case;
 end process;	
 
 
INTARE2:process(current_state1,s1,s2)
 begin
 case current_state1 is 
 when WAIT_CAR =>
 CARRY(1)<='0';
 if(S1(1) = '1' AND S2(1)='0') then 
  next_state1 <= CAR_EN;
 else
  next_state1 <= WAIT_CAR;
 end if;
 when CAR_EN =>
 if(S1(1)='1' AND S2(1) = '1') then 
  next_state1 <= ISCAR;
 else
  next_state1 <= CAR_EN;
 end if;	   
 when ISCAR =>
 if(S1(1) = '0' AND S2(1) = '1') then 
  next_state1 <= CAR_OUT;
 else
  next_state1 <= ISCAR;
 end if; 
 when CAR_OUT =>
 if(S1(1) = '0' AND S2(1) = '0') then 
  next_state1 <= STOP;
 else
  next_state1 <= CAR_OUT;
 end if;
when STOP =>
  CARRY(1)<='1';
 next_state1 <= WAIT_CAR;
 when others => next_state1 <= WAIT_CAR;
 end case;
 end process;
 
 
 IESIRE1:process(current_state2,s1,s2)
 begin			   
	 
 case current_state2 is 
 when WAIT_CAR =>
 CARRY(2)<='0';
 if(S1(2) = '1' AND S2(2)='0') then 
  next_state2 <= CAR_EN;
 else
  next_state2 <= WAIT_CAR;
 end if;
 when CAR_EN =>
 if(S1(2)='1' AND S2(2) = '1') then 
  next_state2 <= ISCAR;
 else
  next_state2 <= CAR_EN;
 end if;	   
 when ISCAR =>
 if(S1(2) = '0' AND S2(2) = '1') then 
  next_state2 <= CAR_OUT;
 else
  next_state2 <= ISCAR;
 end if; 
 when CAR_OUT =>
 if(S1(2) = '0' AND S2(2) = '0') then 
  next_state2 <= STOP;
 else
  next_state2 <= CAR_OUT;
 end if;
when STOP =>
  CARRY(2)<='1';
 next_state2 <= WAIT_CAR;
 when others => next_state2 <= WAIT_CAR;
 end case;
 end process;
 
 
 IESIRE2:process(current_state3,s1,s2)
 begin
 case current_state3 is 
 when WAIT_CAR =>  
 CARRY(3)<='0';
 if(S1(3) = '1' AND S2(3)='0') then 
  next_state3 <= CAR_EN;
 else
  next_state3 <= WAIT_CAR;
 end if;
 when CAR_EN =>
 if(S1(3)='1' AND S2(3) = '1') then 
  next_state3 <= ISCAR;
 else
  next_state3 <= CAR_EN;
 end if;	   
 when ISCAR =>
 if(S1(3) = '0' AND S2(3) = '1') then 
  next_state3 <= CAR_OUT;
 else
  next_state3 <= ISCAR;
 end if; 
 when CAR_OUT =>
 if(S1(3) = '0' AND S2(3) = '0') then 
  next_state3 <= STOP;
 else
  next_state3 <= CAR_OUT;
 end if;
when STOP =>
  CARRY(3)<='1';
 next_state3 <= WAIT_CAR;
 when others => next_state3 <= WAIT_CAR;
 end case;
 end process;
end ss;

library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.STD_LOGIC_unsigned.all;

entity numara is
	port( clk, cd1, cd2, cu1, cu2, reset: in std_logic;
	    n: in std_logic_vector(7 downto 0);
		O: out std_logic_vector(7 downto 0));
end entity;

architecture numm of numara is	  
signal q: std_logic_vector(7 downto 0);
begin
	O <= q;
	process(clk, reset)
	begin
		if reset = '1' then q <= n;
		elsif clk = '1' and clk'event then
			if cu1 = '1' and cu2 = '1' then
				if q = n then
					null;
				else
					q <= q + 2; 
				end if;
			elsif (cu1 = '1' and cu2 = '0') or (cu1 = '0' and cu2 = '1') then
				if q = n then
					null;
				else
					q <= q + '1'; 
				end if;
			end if;
			if cd1 = '1' and cd2 = '1' then
				if q = "0" then
					null;
				else
					q <= q - 2;	
				end if;
			elsif (cd1 = '1' and cd2 = '0') or (cd1 = '0' and cd2 = '1') then
				if q = "0" then
					null;
				else
					q <= q - '1';	
				end if;
			end if;
		end if;	  
	end process;
end numm;   

library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.STD_LOGIC_unsigned.all;
use ieee.numeric_std.all; 
  
--converting a 8bit binary number to a 12bit bcd
entity bin2bcd is
port (bin :in std_logic_vector (7 downto 0);
        bcd1 : out std_logic_vector (3 downto 0);
        bcd2 : out std_logic_vector (3 downto 0);
        bcd3 : out std_logic_vector (3 downto 0));
end bin2bcd;

architecture bb of bin2bcd is 
begin
process ( bin )
    variable binx : std_logic_vector (7 downto 0) ;
    variable bcd     : std_logic_vector (11 downto 0) ;
begin
    bcd             := (others => '0') ;
    binx        := bin(7 downto 0) ;

    for i in binx'range loop
        if bcd(3 downto 0) > "0100" then
          bcd(3 downto 0) := std_logic_vector(unsigned( bcd(3 downto 0)) + "0011"); 

        end if ;
        if bcd(7 downto 4) > "0100" then
           bcd(7 downto 4) := std_logic_vector(unsigned( bcd(7 downto 4)) + "0011");    
        end if ;
        bcd := bcd(10 downto 0) & binx(7) ; 
        binx := binx(6 downto 0) & '0' ; 
    end loop ;

    bcd3 <= bcd(11 downto 8) ;
    bcd2 <= bcd(7  downto 4) ;
    bcd1 <= bcd(3  downto 0) ;
end process ;
end bb;	

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity mux is
	port( in0: in STD_LOGIC_VECTOR(3 downto 0);
	      in1: in STD_LOGIC_VECTOR(3 downto 0);
		  in2: in STD_LOGIC_VECTOR(3 downto 0);
		  in3: in STD_LOGIC_VECTOR(3 downto 0);
		  s: in STD_LOGIC_VECTOR(1 downto 0);
		  O: out STD_LOGIC_VECTOR(3 downto 0));
end mux;

architecture mm of mux is
begin
	process(s)
	begin
case s is
when "00" =>
O <= in0; 
when "01" => 
O <= in1; 
when "10" => 
O <= in2; 
when "11" => 
O <= in3;
when others => 
O <= "0000";
end case;
end process;
end mm;
								  
library IEEE;
use IEEE.std_logic_1164.all; 

entity segm is
port (x : in STD_LOGIC_VECTOR (3 downto 0);
seg : out STD_LOGIC_VECTOR (6 downto 0));
end entity;	

architecture S7 of segm is
begin
process(x)
begin
case x is
when "0000" => seg<="0000001";
when "0001" => seg<="1001111";
when "0010" => seg<="0010010";
when "0011" => seg<="0000110";
when "0100" => seg<="1001100";
when "0101" => seg<="0100100";
when "0110" => seg<="0100000";
when "0111" => seg<="0001111";
when "1000" => seg<="0000000";
when "1001" => seg<="0000100";   
when others =>
seg <= "1111110"; 
end case;  
end process;
end S7;	   

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity numafis is
	port(clk: in std_logic;
			O: out std_logic_vector(15 downto 0));
end numafis;

architecture num of numafis is
signal n: std_logic_vector(15 downto 0) := (others => '0');
begin
	process (clk)
	begin
		if clk'event and clk = '1' then
			n <= n + 1;
		end if;
	end process;
	O <= n;
end num;

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_unsigned.all;

entity afis7s is
	port(	clk: in STD_LOGIC;
			a0: in STD_LOGIC_VECTOR(3 downto 0);
			a1: in STD_LOGIC_VECTOR(3 downto 0);
			a2: in STD_LOGIC_VECTOR(3 downto 0);
			a3: in STD_LOGIC_VECTOR(3 downto 0);
			seg: out STD_LOGIC_VECTOR(6 downto 0);
			nr: out STD_LOGIC_VECTOR(3 downto 0));
end afis7s;

architecture aaa of afis7s is
	component mux 
	port( in0: in STD_LOGIC_VECTOR(3 downto 0);
	      in1: in STD_LOGIC_VECTOR(3 downto 0);
		  in2: in STD_LOGIC_VECTOR(3 downto 0);
		  in3: in STD_LOGIC_VECTOR(3 downto 0);
		  s: in STD_LOGIC_VECTOR(1 downto 0);
		  O: out STD_LOGIC_VECTOR(3 downto 0));
	end component;
	component numafis
	port(clk: in std_logic;
			O: out std_logic_vector(15 downto 0));
	end component;
	component segm
port (x : in STD_LOGIC_VECTOR (3 downto 0);
seg : out STD_LOGIC_VECTOR (6 downto 0));
	end component;
	
	signal aux: std_logic_vector(15 downto 0);
	signal en: std_logic;
	signal muxBCD: std_logic_vector (3 downto 0);
begin
	C1: numafis port map (clk, aux);
	C2: mux port map (a0, a1, a2, a3, aux(15 downto 14), muxBCD);
	C3: segm port map(muxBCD, seg);
	C4: mux port map("1111", "1101", "1011", "0111", aux(15 downto 14), nr);
end aaa; 


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity locuri is
	port(clk,reset:in std_logic;
	nr_locuri:in std_logic_vector(7 downto 0);
	S1, S2: in std_logic_vector(3 downto 0);
	ag: out STD_LOGIC_VECTOR(6 downto 0);
	anod: out STD_LOGIC_VECTOR(3 downto 0));
end locuri;

architecture ll of locuri is
  component STARI
port 
(
  clk,reset_n: in std_logic; 
  s1, s2: in std_logic_vector(3 downto 0);
  CARRY: out std_logic_vector(3 downto 0));  
end component;
component numara
	port( clk, cd1,cd2, cu1, cu2 , reset: in std_logic;
	    n: in std_logic_vector(0 to 7);
		O: out std_logic_vector(0 to 7));
end component;	 
component bin2bcd
port (bin :in std_logic_vector (7 downto 0);
        bcd1 : out std_logic_vector (3 downto 0);
        bcd2 : out std_logic_vector (3 downto 0);
        bcd3 : out std_logic_vector (3 downto 0));
end component;
component afis7s is
	port(	clk: in STD_LOGIC;
			a0: in STD_LOGIC_VECTOR(3 downto 0);
			a1: in STD_LOGIC_VECTOR(3 downto 0);
			a2: in STD_LOGIC_VECTOR(3 downto 0);
			a3: in STD_LOGIC_VECTOR(3 downto 0);
			seg: out STD_LOGIC_VECTOR(6 downto 0);
			nr: out STD_LOGIC_VECTOR(3 downto 0));
end component;	
signal c: std_logic_vector(3 downto 0);	
signal cl: std_logic_vector(3 downto 0);
signal binn1: std_logic_vector(7 downto 0);
	signal B1,B2,B3: std_logic_vector (3 downto 0);		
	
begin
	C1: stari port map (clk,reset,S1,S2,c);
	cl<=c;
	C2: numara port map (clk, cl(0),cl(1),cl(2),cl(3), reset,nr_locuri,binn1);	
	C4: bin2bcd port map(binn1, B1,B2,B3);
	C5: afis7s port map(clk,"0000", B1, B2, B3, ag, anod);
end ll; 
