# OMO_smarthouse_semestral

_Členové týmu:_
Matouš Najman, Jan Pivoňka

_Popis:_

Práce je vytvořená simulace Smart Homr skládající se z 200 taktů, kdy při každém taktu se stane nějaká akce a aktualizují se informace. Povedlo se nám splnit většinu bodů, bohužel se nedostalo na všechny kvůli časové tísni. Největší problém nám dělalo začít. Neměli jsme dost dobrou představu o tom, jak aplikaci navrhnout a museli jsme návrh předělávat. Po předělání návrhu se nám dařilo posunout se kupředu. 

Dále se nám nepodařilo zajistit, aby byl program spustitelný vícekrát v řadě bez rollbacku na souboru houseconfig.json. Při simulaci se JSON soubor přepíše a program dále není spustitelný. Spuštění programu tedy probíhá přes třídu Main, kde je cesta k souboru houseconfig. Tam stačí nakopírovat configy z repa.

_Funkční požadavky (Splněno **tučně**)_

**F1.**	Entity se kterými pracujeme je dům, okno (+ venkovní žaluzie), patro v domu, senzor, zařízení (=spotřebič), osoba, auto, kolo, domácí zvíře jiného než hospodářského typu, plus libovolné další entity

**F2.**	Jednotlivá zařízení v domu mají API na ovládání. Zařízení mají stav, který lze měnit pomocí API na jeho ovládání. Akce z API jsou použitelné podle stavu zařízení. Vybraná zařízení mohou mít i obsah - lednice má jídlo, CD přehrávač má CD.

**F3.**	Spotřebiče mají svojí spotřebu v aktivním stavu, idle stavu, vypnutém stavu

**F4.**	Jednotlivá zařízení mají API na sběr dat o tomto zařízení. O zařízeních sbíráme data jako spotřeba elektřiny, plynu, vody a funkčnost (klesá lineárně s časem)

**F5.**	Jednotlivé osoby a zvířata mohou provádět aktivity(akce), které mají nějaký efekt na zařízení nebo jinou osobu. Např. Plynovy_kotel_1[oteverny_plyn] + Otec.zavritPlyn(plynovy_kotel_1) -> Plynovy_kotel_1[zavreny_plyn].

**F6.**	Jednotlivá zařízení a osoby se v každém okamžiku vyskytují v jedné místnosti (pokud nesportují) a náhodně generují eventy (eventem může být důležitá informace a nebo alert)

F7.	Eventy jsou přebírány a odbavovány vhodnou osobou (osobami) nebo zařízením (zařízeními).

**F8.**	Vygenerování reportů:

**F9.**	Při rozbití zařízení musí obyvatel domu prozkoumat dokumentaci k zařízení - najít záruční list, projít manuál na opravu a provést nápravnou akcí (např. Oprava svépomocí, koupě nového atd.). Manuály zabírají mnoho místa a trvá dlouho než je najdete. Hint: Modelujte jako jednoduché akce ...dokumentace je přístupná jako proměnná přímo v zařízení, nicméně se dotahuje až, když je potřeba. 

F10.	Rodina je aktivní a volný čas tráví zhruba v poměru (50% používání spotřebičů v domě a 50% sport kdy používá sportovní náčiní kolo nebo lyže). Když není volné zařízení nebo sportovní náčiní, tak osoba čeká.

Used design patterns:

- Singleton
- Simple Factory
- Abstract Factory
- state machine
- observer
- visitor

 (využití viz UML)



