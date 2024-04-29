PGDMP     .                    |            foot     12.13 (Debian 12.13-1.pgdg110+1)    14.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    72925    foot    DATABASE     X   CREATE DATABASE foot WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';
    DROP DATABASE foot;
                postgres    false            �            1259    72958    players    TABLE       CREATE TABLE public.players (
    id integer NOT NULL,
    name character varying,
    age character varying,
    nationality character varying,
    height real,
    weight real,
    number real,
    position_name character varying,
    carrier_start_date character varying
);
    DROP TABLE public.players;
       public         heap    postgres    false            �            1259    72956    players_id_seq    SEQUENCE     w   CREATE SEQUENCE public.players_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.players_id_seq;
       public          postgres    false    203            �           0    0    players_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.players_id_seq OWNED BY public.players.id;
          public          postgres    false    202            �            1259    81062    users_id_seq    SEQUENCE     u   CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false            �            1259    81064    users    TABLE        CREATE TABLE public.users (
    id integer DEFAULT nextval('public.users_id_seq'::regclass) NOT NULL,
    name character varying(100),
    email character varying(100),
    login character varying(100),
    pwd character varying(100),
    level integer
);
    DROP TABLE public.users;
       public         heap    postgres    false    204                       2604    72961 
   players id    DEFAULT     h   ALTER TABLE ONLY public.players ALTER COLUMN id SET DEFAULT nextval('public.players_id_seq'::regclass);
 9   ALTER TABLE public.players ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            �          0    72958    players 
   TABLE DATA           x   COPY public.players (id, name, age, nationality, height, weight, number, position_name, carrier_start_date) FROM stdin;
    public          postgres    false    203   y       �          0    81064    users 
   TABLE DATA           C   COPY public.users (id, name, email, login, pwd, level) FROM stdin;
    public          postgres    false    205   �       �           0    0    players_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.players_id_seq', 3, true);
          public          postgres    false    202            �           0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 1, false);
          public          postgres    false    204                       2606    72966    players players_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.players
    ADD CONSTRAINT players_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.players DROP CONSTRAINT players_pkey;
       public            postgres    false    203            �     x��\���<��?��l��t��8_r�e�;k���u����MI,�g{(,X�Yd���K/������_�KZ^����������������/%~�������X^~:4�!�󋔡q~������O�_;e
�N�ez��o>�r��PvJa���ϷO��^==����*#U�9�;ef����oo�}��=q	�N_}y�����~Їv�֝�2�z��C�6�������8Ʊ�S
)'N�!IH�#GX����!e��G��)$�A�H���߿|�߇��:��dbH��
y��i!U�1-����6�!�0�L��[B2�el|�?i��?�cc2$1�?����h���u��M��~x�����3HrӀdF�	i
bR�����OJӄ�K��M�q�Ib�P ˅1�c%sS��>�+ec�����_���o,9v��Z��.0V>��[C6q(`������1dS�־\�!����B6y(`�z}���=adʚ���A3��E���7,H7ٴ�����ؽ}	�T�+k/�:��&�6h�O!�1�l�P@H2�qA�ɦ��ɳ�0�0�4�4�L�gR��M�=@
��D	POsgI�L$
k>����w�����_�q�4�L�*���^����3�:0�.�U��&�J<����3�8P��Y��&�J����PL"%r��(Q�b�)��(OB�PL2
h�z�(�S�Ԣ�澎�bzQ@	�5�d��P.�D����b
W�P�hz*��r��9�M��ZB1�(2��\�x���FarpA��&�V�c�S���*�}�]E��&�f_P.}R����D!-�U�j2Q@h+����z�RQW��,��J0Vz4��V'�b��$�����4�a�_��fӊ�w��}�O��D���/����0�T0�y���4��&'�����/��Ԣ���4	��Ec����lJQ@X�E!y�E����L�{ �z�ID{�����fS�B���氘4��H�}��M!Kb���	[�5,&�EX�:lz7���ԱPu��;iF[L��r��m$,����d} ���P���r�Mu��c!��J��JX�� *��J��jXL&�I+�ƛ�jJQ�����Ӗ��P0V!�5����x�i�[M7
H ��mF�ZM1
H�|���j5�( ��?fd�Ք��D�IIo U��@ھEۛOa5e( ��a�5b	��c+#��F�!�n�EF��0-Ĭ!�5�[a|���.Ƣ1�E�Bc�S7��p-f�8��o��K��屣`F��b���zۘ�Lw��:2ybV�;i��ޤ<7�1ޭ;��(ý6E,ƲO��P!u��+a�d<T=�51�D򖪘��x%ϣá���+�W��]i�\1i+���<Lɍ�)0uV���F��QDh���BE�m�4��F�B����tq�})�;*�m-�mZ�l.4�*�M��\ڻ%�HS�Q��SK��닁�*ݲ�L��t�a�$S���{�I&ʻ��-\HRXˊ����-!�q,�v�oDhW���˅�@�v͍���q�H{�.;6���M[ B�c��`ܿ"ԅ�����[ B�ϐ[,���dB��/�w��ƽ[ ƹ�V���s�X9v/�;�@�At����.���68���xT9�N��1f%OT���x3�z����O2��Y�[��/����ۻ@�q��O�3�É>���	{��F/{�8	���^/!�.��Mqr���C͝��P׌"B-��Tj��I�Sq+NBr������8m��]^ B��h[U���@$�z�[����@��Ѥ-����xD5�o�3ʣ�AZs��13y����^ M�@��nn��<�©����`��!r�����f����������^ B#"G�s���*	Ռ۾@�8E���/��1Fa���Fu�����_���j��P�A��b���b1�O��Q����8O��s���?�Ae�/!d?�Ae�/!L��=�pY�����

��;�@�v�Y#����"�y|Ҡ{�@Tl�l���_ *��CY�P���:/�c	�2��@�q�� �j�=` ƻ�~ O��60�(�Q%�F0ЃB�T,n�X7*���`Zt_��AS��Dh���I�a �'�l��-` Byt�!T6�
�˱o�і~��f=��̽` .�AfH`�qyC�<�n0��XW�j����<U���@O��F�1W�J˦'S���a ^���ɝa ^�c�l��0�φ�DFr����X ��
-�NS��b�@G���)�cn*���N0Ѓ�����}0����&�4�5/���@t���W�b�1�i�k�&�B/�V���@l�{��ǭ87��流�����u��vU���[y&n1�uO��LR�xIw�����L�b���W-���=a ZO�B%�0�}%qz����` Z=��9L���2y������D��ҽ� �|�a<�mTՊ��@�z?�Z�N��'x��զ�L�u]���#w.n�.�rW&�zI��o�
ue�I/�ͤ_����h:�~[W�!3�nL�|�7v�j&��7���]E�munw�]3�������]E�6=����f0	Q�Àt�0!�q���"��e��Jr���m�c�jq��ף ����"H��[�-�|��j���jq���n/C!�V��ۿ@Tq�n����@mwOU�D��ޭ4�~�h�Ӂ�:s���m���D�F���@��ҏ�1�z�h�q��"7z�x�1����zP���e��/���t�/���q@*s��V��;�L����1{1|��r)T.'A"e��DI��V����@T�㻩\J�l���av�J3q��H�^���@�Ϝ�Ž �|�H��q���-^ ư���O��b�sv�{�'n�1�U1q� �}^ s_"Y�����q�U����}��V	��DB�S�Fk�ڨ2B%ݩjqs��f��w�횦�U|���zTR���@�@�t���^ �=��dş;�@����ވlU���@$D[�"�}^ B�����A�|�H����V��Dף�d���?V��^�O��&/��[[��/�=���jA�{�H��z�U�n�1R��^ �H�nA�t��q���Ɋ@�|�X�|�KU)n�сoJ�7q�
�/��y��FC�Nz��=kDte���^�왯QГ���^�<o�M;��]�^��۳��.twW��}�n�Z�n�������o1t*��+�ۿ>�Ǳ�ǟ.��`f36��D7y�z�43H K�;��/_]�FT���+������[w\3�"�x�Z�G	��A��N�y�ؿ����A���d7y��y�1�~� ����p��?V���zp8Z��*���==-�Odwt���({#|X���Fz�X���zvo���h�� ����`��Y����S�e���6/?�?��.�9�粒V�ߪ�p�ʃ��*7u��L���(��DeB��*ٍ]����e�E���.�s�>Bw���B��p�����������      �   $   x�3�LL��̃�鹉�9z���Ȣ��\1z\\\ :@     