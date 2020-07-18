-- PostgreSQL database dump
--

-- Dumped from database version 10.13
-- Dumped by pg_dump version 12.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- Name: ratings; Type: TABLE; Schema: public; Owner: oyo
--

CREATE TABLE public.ratings (
    ride_id bigint NOT NULL,
    driver_id bigint,
    customer_id bigint,
    rated_by integer NOT NULL,
    rating integer
);


ALTER TABLE public.ratings OWNER TO oyo;

--
-- Data for Name: ratings; Type: TABLE DATA; Schema: public; Owner: oyo
--

COPY public.ratings (ride_id, driver_id, customer_id, rated_by, rating) FROM stdin;
1	21	30	0	4
\.


--
-- Name: ratings ratings_pkey; Type: CONSTRAINT; Schema: public; Owner: oyo
--

ALTER TABLE ONLY public.ratings
    ADD CONSTRAINT ratings_pkey PRIMARY KEY (ride_id, rated_by);


--
-- Name: idx_cust; Type: INDEX; Schema: public; Owner: oyo
--

CREATE INDEX idx_cust ON public.ratings USING btree (customer_id) WHERE (rated_by = 1);


--
-- Name: idx_driv; Type: INDEX; Schema: public; Owner: oyo
--

CREATE INDEX idx_driv ON public.ratings USING btree (driver_id) WHERE (rated_by = 0);


--
-- PostgreSQL database dump complete
--